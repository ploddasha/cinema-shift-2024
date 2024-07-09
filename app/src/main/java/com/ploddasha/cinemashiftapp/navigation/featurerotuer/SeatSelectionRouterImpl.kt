package com.ploddasha.cinemashiftapp.navigation.featurerotuer

import com.ploddasha.cinemashiftapp.confirmation.ConfirmationRoute
import com.ploddasha.cinemashiftapp.navigation.GlobalRouter
import com.ploddasha.cinemashiftapp.seatselection.presentation.SeatSelectionRouter


class SeatSelectionRouterImpl(private val globalRouter: GlobalRouter) : SeatSelectionRouter {

    override fun goBack() {
        globalRouter.pop()
    }

    override fun openConfirmation(filmId: String) {
        globalRouter.open(ConfirmationRoute(filmId))
    }

}