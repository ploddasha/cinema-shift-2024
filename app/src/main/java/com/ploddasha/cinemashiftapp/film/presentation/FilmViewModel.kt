package com.ploddasha.cinemashiftapp.film.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ploddasha.cinemashiftapp.film.domain.usecase.GetFilmUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

class FilmViewModel(
    private val filmId: String,
    private val getFilmUseCase: GetFilmUseCase,
    private val router: FilmRouter,
    private val backendAddress: String
) : ViewModel() {

    private val _state = MutableStateFlow<FilmState>(FilmState.Initial)
    val state: StateFlow<FilmState> = _state

    fun loadFilm() {
        if (_state.value is FilmState.Content || _state.value is FilmState.Loading) {
            return
        }

        viewModelScope.launch {
            _state.value = FilmState.Loading

            try {
                val film = getFilmUseCase(filmId)
                _state.value = FilmState.Content(film)
            } catch (ce: CancellationException) {
                throw ce
            } catch (ex: Exception) {
                _state.value = FilmState.Failure(ex.message)
            }
        }
    }

    fun getBackendAddress(): String {
        return backendAddress
    }

    fun goBack() {
        router.goBack()
    }

    fun openSchedule(filmId: String) {
        router.openSchedule(filmId)
    }
}