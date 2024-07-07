package com.ploddasha.cinemashiftapp.schedule.domain.entity

data class ScheduleItem(
    val date: String,
    val seances: List<SeanceItem>
)