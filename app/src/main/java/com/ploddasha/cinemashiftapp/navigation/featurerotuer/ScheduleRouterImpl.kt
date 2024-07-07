package com.ploddasha.cinemashiftapp.navigation.featurerotuer

import com.ploddasha.cinemashiftapp.navigation.GlobalRouter
import com.ploddasha.cinemashiftapp.schedule.presentation.ScheduleRouter


class ScheduleRouterImpl(private val globalRouter: GlobalRouter) : ScheduleRouter {

    override fun goBack() {
        globalRouter.pop()
    }

}