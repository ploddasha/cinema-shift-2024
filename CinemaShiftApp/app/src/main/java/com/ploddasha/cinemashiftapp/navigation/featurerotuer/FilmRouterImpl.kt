package com.ploddasha.cinemashiftapp.navigation.featurerotuer

import com.ploddasha.cinemashiftapp.film.presentation.FilmRouter
import com.ploddasha.cinemashiftapp.navigation.GlobalRouter

class FilmRouterImpl(private val globalRouter: GlobalRouter) : FilmRouter {

    override fun goBack() {
        globalRouter.pop()
    }
}