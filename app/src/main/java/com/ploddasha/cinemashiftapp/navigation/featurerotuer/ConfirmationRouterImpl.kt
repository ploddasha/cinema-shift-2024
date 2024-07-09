package com.ploddasha.cinemashiftapp.navigation.featurerotuer

import com.ploddasha.cinemashiftapp.confirmation.presentation.ConfirmationRouter
import com.ploddasha.cinemashiftapp.navigation.GlobalRouter
import com.ploddasha.cinemashiftapp.personinput.PersonInputRoute

class ConfirmationRouterImpl(private val globalRouter: GlobalRouter) : ConfirmationRouter {

    override fun goBack() {
        globalRouter.pop()
    }

    override fun openPersonInput(filmId: String) {
        globalRouter.open(PersonInputRoute(filmId))
    }

}