package com.ploddasha.cinemashiftapp.schedule.presentation

import com.ploddasha.cinemashiftapp.common.presentation.SelectedData

interface ScheduleRouter {
    fun goBack()

    fun openSeatSelection(filmId: String)

}