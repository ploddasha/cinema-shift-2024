package com.ploddasha.cinemashiftapp.schedule.data.repository

import com.ploddasha.cinemashiftapp.schedule.data.converter.ScheduleItemConverter
import com.ploddasha.cinemashiftapp.schedule.data.network.ScheduleApi
import com.ploddasha.cinemashiftapp.schedule.domain.entity.ScheduleItem
import com.ploddasha.cinemashiftapp.schedule.domain.repository.ScheduleRepository

class ScheduleRepositoryImpl(
    private val scheduleApi: ScheduleApi,
    private val scheduleItemConverter: ScheduleItemConverter,
) : ScheduleRepository {

    override suspend fun getSchedule(filmId: String): List<ScheduleItem> {
        val response = scheduleApi.getSchedule(filmId)
        return if (response.success) {
            response.schedules.map { scheduleItemConverter.convert(it) }
        } else {
            // TODO Обработка ошибки
            emptyList()
        }
    }
}