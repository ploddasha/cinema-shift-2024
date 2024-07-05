package com.ploddasha.cinemashiftapp.navigation

import androidx.navigation.NavController

class GlobalRouterImpl : GlobalRouter, NavControllerHolder {

    private var navController: NavController? = null

    override fun open(route: Any) {
        navController?.navigate(route)
    }

    override fun openPoppingAllPrevious(route: Any) {
        val navController = navController ?: return
        navController.navigate(route) {
            popUpTo(navController.graph.startDestinationId)
            launchSingleTop = true
        }
    }

    override fun pop() {
        navController?.popBackStack()
    }

    override fun setNavController(navController: NavController) {
        this.navController = navController
    }

    override fun clearNavController() {
        navController = null
    }
}