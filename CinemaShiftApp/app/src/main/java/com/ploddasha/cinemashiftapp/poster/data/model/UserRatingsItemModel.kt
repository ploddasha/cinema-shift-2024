package com.ploddasha.cinemashiftapp.poster.data.model

import kotlinx.serialization.Serializable

@Serializable
data class UserRatingsItemModel(
    val kinopoisk: String,
    val imdb: String
)