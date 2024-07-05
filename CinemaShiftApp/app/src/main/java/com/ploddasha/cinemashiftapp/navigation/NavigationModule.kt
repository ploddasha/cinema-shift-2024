package com.ploddasha.cinemashiftapp.navigation

import com.ploddasha.cinemashiftapp.main.presentation.MainRouter
import com.ploddasha.cinemashiftapp.poster.presentation.FilmPosterRouter
import com.ploddasha.cinemashiftapp.navigation.featurerotuer.FilmPosterRouterImpl
import com.ploddasha.cinemashiftapp.navigation.featurerotuer.MainRouterImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.binds
import org.koin.dsl.bind
import org.koin.dsl.module

val navigationModule = module {
    singleOf(::GlobalRouterImpl) binds arrayOf(GlobalRouter::class, NavControllerHolder::class)

    singleOf(::MainRouterImpl) bind MainRouter::class
    singleOf(::FilmPosterRouterImpl) bind FilmPosterRouter::class
}