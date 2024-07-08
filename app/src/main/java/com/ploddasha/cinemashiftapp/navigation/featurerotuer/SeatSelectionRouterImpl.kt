package com.ploddasha.cinemashiftapp.navigation.featurerotuer

import com.ploddasha.cinemashiftapp.common.presentation.SelectedData
import com.ploddasha.cinemashiftapp.navigation.GlobalRouter
import com.ploddasha.cinemashiftapp.seatselection.SeatSelectionRoute
import com.ploddasha.cinemashiftapp.seatselection.presentation.SeatSelectionRouter


class SeatSelectionRouterImpl(private val globalRouter: GlobalRouter) : SeatSelectionRouter {

    override fun goBack() {
        globalRouter.pop()
    }

}