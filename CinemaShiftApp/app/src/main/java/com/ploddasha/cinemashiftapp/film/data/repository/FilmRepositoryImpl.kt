package com.ploddasha.cinemashiftapp.film.data.repository

import com.ploddasha.cinemashiftapp.film.data.converter.FilmConverter
import com.ploddasha.cinemashiftapp.film.data.network.FilmApi
import com.ploddasha.cinemashiftapp.film.domain.entity.Film
import com.ploddasha.cinemashiftapp.film.domain.repository.FilmRepository

class FilmRepositoryImpl(
    private val filmApi: FilmApi,
    private val filmConverter: FilmConverter,
) : FilmRepository {

    override suspend fun getFilm(filmId: String): Film? {
        val response = filmApi.getFilm(filmId)
        return if (response.success) {
            filmConverter.convert(response.film)
        } else {
            // TODO Обработка ошибки
            return null
        }
    }
}