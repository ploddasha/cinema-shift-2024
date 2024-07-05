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
    private val router: FilmPosterRouter
): ViewModel() {
    private val _state = MutableStateFlow<FilmPosterState>(FilmPosterState.Initial)
    val state: StateFlow<FilmPosterState> = _state

    fun loadFilms() {
        if (_state.value is FilmPosterState.Content || _state.value is FilmPosterState.Loading) {
            return
        }
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

    /*
    fun openFilm(filmId: Long) {
        router.openFilm(filmId)
    } */
}