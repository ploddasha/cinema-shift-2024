package com.ploddasha.cinemashiftapp.poster.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ActorItemModel(
    val id: String,
    val professions: List<String>,
    val fullName: String
)