package com.ploddasha.cinemashiftapp.main.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel(
    private val router: MainRouter,
) : ViewModel() {

    private val _state = MutableStateFlow(MainState(
        NavigationOption.entries,
        NavigationOption.POSTER,
    ))
    val state: StateFlow<MainState> = _state

    fun openOption(option: NavigationOption) {
        _state.value = _state.value.copy(selectedNavOption = option)
        when (option) {
            NavigationOption.POSTER    -> router.openPoster()
            NavigationOption.TICKETS    -> router.openPoster() //TODO change
            NavigationOption.PROFILE    -> router.openPoster() //TODO change

        }
    }

    fun handleOpenedScreen(option: NavigationOption?) {
        _state.value = _state.value.copy(selectedNavOption = option)
    }
}