package com.ploddasha.cinemashiftapp.film.data.network

import com.ploddasha.cinemashiftapp.film.data.model.FilmDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface FilmApi {

    @GET("film/{filmId}")
    suspend fun getFilm(@Path("filmId") filmId: String): FilmDetailsResponse

}