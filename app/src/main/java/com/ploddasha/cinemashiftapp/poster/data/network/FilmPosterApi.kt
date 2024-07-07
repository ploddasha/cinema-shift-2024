package com.ploddasha.cinemashiftapp.poster.data.network

import com.ploddasha.cinemashiftapp.poster.data.model.FilmResponse
import retrofit2.http.GET

interface FilmPosterApi {

    @GET("today")
    suspend fun getAll(): FilmResponse

}