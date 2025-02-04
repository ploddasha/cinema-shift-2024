package com.ploddasha.cinemashiftapp.navigation

import com.ploddasha.cinemashiftapp.confirmation.presentation.ConfirmationRouter
import com.ploddasha.cinemashiftapp.film.presentation.FilmRouter
import com.ploddasha.cinemashiftapp.main.presentation.MainRouter
import com.ploddasha.cinemashiftapp.poster.presentation.FilmPosterRouter
import com.ploddasha.cinemashiftapp.navigation.featurerotuer.ConfirmationRouterImpl
import com.ploddasha.cinemashiftapp.navigation.featurerotuer.FilmPosterRouterImpl
import com.ploddasha.cinemashiftapp.navigation.featurerotuer.MainRouterImpl
import com.ploddasha.cinemashiftapp.navigation.featurerotuer.ScheduleRouterImpl
import com.ploddasha.cinemashiftapp.navigation.featurerotuer.FilmRouterImpl
import com.ploddasha.cinemashiftapp.navigation.featurerotuer.SeatSelectionRouterImpl
import com.ploddasha.cinemashiftapp.navigation.featurerotuer.PersonInputRouterImpl
import com.ploddasha.cinemashiftapp.personinput.presentation.PersonInputRouter
import com.ploddasha.cinemashiftapp.schedule.presentation.ScheduleRouter
import com.ploddasha.cinemashiftapp.seatselection.presentation.SeatSelectionRouter
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.binds
import org.koin.dsl.bind
import org.koin.dsl.module

val navigationModule = module {
    singleOf(::GlobalRouterImpl) binds arrayOf(GlobalRouter::class, NavControllerHolder::class)

    singleOf(::MainRouterImpl) bind MainRouter::class
    singleOf(::FilmPosterRouterImpl) bind FilmPosterRouter::class
    singleOf(::FilmRouterImpl) bind FilmRouter::class
    singleOf(::ScheduleRouterImpl) bind ScheduleRouter::class
    singleOf(::SeatSelectionRouterImpl) bind SeatSelectionRouter::class
    singleOf(::ConfirmationRouterImpl) bind ConfirmationRouter::class
    singleOf(::PersonInputRouterImpl) bind PersonInputRouter::class


}