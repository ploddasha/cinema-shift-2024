package com.ploddasha.cinemashiftapp.poster.data.network

import com.ploddasha.cinemashiftapp.poster.data.model.FilmItemModel
import retrofit2.http.GET

interface FilmPosterApi {

    @GET("cinema/today")
    suspend fun getAll(): List<FilmItemModel>
}