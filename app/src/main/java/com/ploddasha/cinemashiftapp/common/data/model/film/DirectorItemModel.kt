package com.ploddasha.cinemashiftapp.common.data.model.film

import kotlinx.serialization.Serializable

@Serializable
data class DirectorItemModel(
    val id: String,
    val professions: List<String>,
    val fullName: String
)