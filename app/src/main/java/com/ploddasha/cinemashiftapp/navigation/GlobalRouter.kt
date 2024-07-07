package com.ploddasha.cinemashiftapp.navigation

interface GlobalRouter {

    fun open(route: Any)

    fun openPoppingAllPrevious(route: Any)

    fun pop()
}