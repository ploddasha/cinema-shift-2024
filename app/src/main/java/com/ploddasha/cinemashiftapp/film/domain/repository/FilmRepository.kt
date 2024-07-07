package com.ploddasha.cinemashiftapp.film.domain.repository

import com.ploddasha.cinemashiftapp.film.domain.entity.Film

interface FilmRepository {

    suspend fun getFilm(filmId: String): Film?
}