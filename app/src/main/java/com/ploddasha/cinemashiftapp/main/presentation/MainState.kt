package com.ploddasha.cinemashiftapp.main.presentation

data class MainState(
    val navigationOptions: List<NavigationOption>,
    val selectedNavOption: NavigationOption?,
)