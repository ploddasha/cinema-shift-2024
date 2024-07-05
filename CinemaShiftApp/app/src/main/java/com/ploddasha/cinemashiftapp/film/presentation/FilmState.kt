package com.ploddasha.cinemashiftapp.film.presentation

import com.ploddasha.cinemashiftapp.film.domain.entity.Film


interface FilmState {

    data object Initial : FilmState
    data object Loading : FilmState
    data class Failure(val message: String?) : FilmState
    data class Content(val film: Film?) : FilmState
}