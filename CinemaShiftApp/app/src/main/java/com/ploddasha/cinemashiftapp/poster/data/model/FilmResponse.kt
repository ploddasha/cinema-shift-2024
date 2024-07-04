package com.ploddasha.cinemashiftapp.poster.data.model

data class FilmResponse(
    val success: Boolean,
    val films: List<FilmItemModel>
)