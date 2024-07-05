package com.ploddasha.cinemashiftapp.navigation.featurerotuer

import com.ploddasha.cinemashiftapp.film.presentation.FilmRouter
import com.ploddasha.cinemashiftapp.navigation.GlobalRouter
import com.ploddasha.cinemashiftapp.schedule.ScheduleRoute

class FilmRouterImpl(private val globalRouter: GlobalRouter) : FilmRouter {

    override fun goBack() {
        globalRouter.pop()
    }

    override fun openSchedule(filmId: String) {
        globalRouter.open(ScheduleRoute(filmId))
    }
}