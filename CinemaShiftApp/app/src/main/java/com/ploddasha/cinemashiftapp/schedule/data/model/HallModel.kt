package com.ploddasha.cinemashiftapp.schedule.data.model

import kotlinx.serialization.Serializable

@Serializable
data class HallModel(
    val name: String,
    val placeModels: List<List<PlaceModel>>
)