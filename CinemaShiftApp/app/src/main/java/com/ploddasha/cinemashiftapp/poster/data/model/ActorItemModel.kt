package com.ploddasha.cinemashiftapp.poster.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ActorItemModel(
    val id: String,
    val professions: String,
    val fullName: String
)