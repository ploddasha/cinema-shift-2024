package com.ploddasha.cinemashiftapp.poster.domain.repository

import com.ploddasha.cinemashiftapp.poster.domain.entity.FilmItem

interface FilmPosterRepository {
    suspend fun getAll(): List<FilmItem>
}