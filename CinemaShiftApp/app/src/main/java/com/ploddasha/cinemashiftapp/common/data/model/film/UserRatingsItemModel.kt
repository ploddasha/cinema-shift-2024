package com.ploddasha.cinemashiftapp.common.data.model.film

import kotlinx.serialization.Serializable

@Serializable
data class UserRatingsItemModel(
    val kinopoisk: String,
    val imdb: String
)