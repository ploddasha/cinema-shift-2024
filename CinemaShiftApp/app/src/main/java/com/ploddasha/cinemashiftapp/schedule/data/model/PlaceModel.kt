package com.ploddasha.cinemashiftapp.schedule.data.model

import kotlinx.serialization.Serializable

@Serializable
data class PlaceModel(
    val price: Int,
    val type: String
)