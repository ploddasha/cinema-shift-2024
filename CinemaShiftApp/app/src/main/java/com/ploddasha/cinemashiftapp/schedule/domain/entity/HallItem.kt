package com.ploddasha.cinemashiftapp.schedule.domain.entity

data class HallItem(
    val name: String,
    val places: List<List<PlaceItem>>
)