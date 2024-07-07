package com.ploddasha.cinemashiftapp.common.data.model.film

import kotlinx.serialization.Serializable

@Serializable
data class CountryItemModel(
    val name: String,
    val code: String,
    val code2: String,
    val id: Int
)