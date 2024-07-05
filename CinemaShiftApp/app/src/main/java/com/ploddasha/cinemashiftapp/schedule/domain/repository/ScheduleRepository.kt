package com.ploddasha.cinemashiftapp.schedule.domain.repository

import com.ploddasha.cinemashiftapp.schedule.domain.entity.ScheduleItem

interface ScheduleRepository {

    suspend fun getSchedule(filmId: String): List<ScheduleItem>
}