package com.ploddasha.cinemashiftapp.poster.data.repository

import com.ploddasha.cinemashiftapp.poster.data.converter.FilmItemConverter
import com.ploddasha.cinemashiftapp.poster.data.network.FilmPosterApi
import com.ploddasha.cinemashiftapp.poster.domain.entity.FilmItem
import com.ploddasha.cinemashiftapp.poster.domain.repository.FilmPosterRepository

class FilmPosterRepositoryImpl(
    private val filmPosterApi: FilmPosterApi,
    private val filmItemConverter: FilmItemConverter,
) : FilmPosterRepository {

    override suspend fun getAll(): List<FilmItem> {
        val models = filmPosterApi.getAll()
        return models.map { filmItemConverter.convert(it) }
    }
}