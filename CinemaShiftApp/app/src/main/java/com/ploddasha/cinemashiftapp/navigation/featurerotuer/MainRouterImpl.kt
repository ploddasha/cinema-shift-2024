package com.ploddasha.cinemashiftapp.navigation.featurerotuer

import com.ploddasha.cinemashiftapp.main.presentation.MainRouter
import com.ploddasha.cinemashiftapp.navigation.GlobalRouter
import com.ploddasha.cinemashiftapp.poster.FilmPosterRoute


class MainRouterImpl(private val globalRouter: GlobalRouter) : MainRouter {

    override fun openPoster() {
        globalRouter.openPoppingAllPrevious(FilmPosterRoute)
    }

}