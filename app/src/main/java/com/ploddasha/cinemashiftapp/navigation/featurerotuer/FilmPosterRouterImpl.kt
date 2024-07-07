package com.ploddasha.cinemashiftapp.navigation.featurerotuer

import com.ploddasha.cinemashiftapp.film.FilmRoute
import com.ploddasha.cinemashiftapp.navigation.GlobalRouter
import com.ploddasha.cinemashiftapp.poster.presentation.FilmPosterRouter

class FilmPosterRouterImpl(private val globalRouter: GlobalRouter) : FilmPosterRouter {
    override fun openFilm(filmId: String) {
        globalRouter.open(FilmRoute(filmId))
    }

}