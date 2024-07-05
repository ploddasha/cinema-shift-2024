package com.ploddasha.cinemashiftapp.film.domain.usecase

import com.ploddasha.cinemashiftapp.film.domain.entity.Film
import com.ploddasha.cinemashiftapp.film.domain.repository.FilmRepository

class GetFilmUseCase(private val filmRepository: FilmRepository) {

    suspend operator fun invoke(filmId: String): Film? =
        filmRepository.getFilm(filmId)
}