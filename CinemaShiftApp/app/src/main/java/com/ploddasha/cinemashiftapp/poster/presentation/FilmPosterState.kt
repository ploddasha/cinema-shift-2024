package com.ploddasha.cinemashiftapp.poster.presentation

import com.ploddasha.cinemashiftapp.poster.domain.entity.FilmItem

sealed interface FilmPosterState {

    data object Initial: FilmPosterState
    data object Loading: FilmPosterState
    data class Failure(val message: String?): FilmPosterState
    data class Content(val films: List<FilmItem>): FilmPosterState
}