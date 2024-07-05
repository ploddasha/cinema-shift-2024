package com.ploddasha.cinemashiftapp.film.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ActorItemModel(
    val id: String,
    val professions: List<String>,
    val fullName: String
)