package com.ploddasha.cinemashiftapp.main.presentation

import com.ploddasha.cinemashiftapp.poster.FilmPosterRoute
import kotlin.reflect.KClass

enum class NavigationOption(val route: KClass<*>) {
    POSTER(FilmPosterRoute::class),
    TICKETS(FilmPosterRoute::class), //TODO change
    PROFILE(FilmPosterRoute::class), //TODO change
}