package com.ploddasha.cinemashiftapp.poster.domain

import com.ploddasha.cinemashiftapp.poster.domain.entity.FilmItem
import com.ploddasha.cinemashiftapp.poster.domain.repository.FilmPosterRepository

class GetFilmPosterUseCase(private val repository: FilmPosterRepository) {

    suspend operator fun invoke(): List<FilmItem> =
        repository.getAll()
}