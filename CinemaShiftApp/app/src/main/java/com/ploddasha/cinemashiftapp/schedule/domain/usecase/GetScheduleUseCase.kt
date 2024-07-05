package com.ploddasha.cinemashiftapp.schedule.domain.usecase

import com.ploddasha.cinemashiftapp.schedule.domain.entity.ScheduleItem
import com.ploddasha.cinemashiftapp.schedule.domain.repository.ScheduleRepository

class GetScheduleUseCase(private val scheduleRepository: ScheduleRepository) {

    suspend operator fun invoke(filmId: String): List<ScheduleItem> =
        scheduleRepository.getSchedule(filmId)
}