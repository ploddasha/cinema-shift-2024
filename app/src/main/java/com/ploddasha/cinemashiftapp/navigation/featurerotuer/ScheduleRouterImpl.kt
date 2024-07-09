package com.ploddasha.cinemashiftapp.navigation.featurerotuer

import com.ploddasha.cinemashiftapp.navigation.GlobalRouter
import com.ploddasha.cinemashiftapp.schedule.presentation.ScheduleRouter
import com.ploddasha.cinemashiftapp.seatselection.SeatSelectionRoute


class ScheduleRouterImpl(private val globalRouter: GlobalRouter) : ScheduleRouter {

    override fun goBack() {
        globalRouter.pop()
    }

    override fun openSeatSelection(filmId: String) {
        globalRouter.open(SeatSelectionRoute(filmId))
    }

}