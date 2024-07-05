package com.ploddasha.cinemashiftapp.film.data.model

import kotlinx.serialization.Serializable

@Serializable
data class FilmDetailsResponse(
    val success: Boolean,
    val film: FilmDetailsModel
)