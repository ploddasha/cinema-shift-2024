package com.ploddasha.cinemashiftapp.poster.data.model

import kotlinx.serialization.Serializable

@Serializable
data class FilmResponse(
    val success: Boolean,
    val films: List<FilmItemModel>
)