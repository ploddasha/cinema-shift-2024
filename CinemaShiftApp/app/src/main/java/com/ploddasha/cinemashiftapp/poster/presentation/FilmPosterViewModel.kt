package com.ploddasha.cinemashiftapp.poster.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ploddasha.cinemashiftapp.poster.domain.GetFilmPosterUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FilmPosterViewModel(
    private val getFilmPosterUseCase: GetFilmPosterUseCase,
): ViewModel() {
    private val _state = MutableStateFlow<FilmPosterState>(FilmPosterState.Initial)
    val state: StateFlow<FilmPosterState> = _state

    fun loadFilms() {
        viewModelScope.launch {
            _state.value = FilmPosterState.Loading

            try {
                val loans = getFilmPosterUseCase()
                _state.value = FilmPosterState.Content(loans)
            } catch (ce: CancellationException) {
                throw ce
            } catch (ex: Exception) {
                _state.value = FilmPosterState.Failure(ex.localizedMessage.orEmpty())
            }
        }
    }

}