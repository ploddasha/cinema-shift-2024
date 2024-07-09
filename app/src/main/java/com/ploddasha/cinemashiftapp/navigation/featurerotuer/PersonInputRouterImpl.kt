package com.ploddasha.cinemashiftapp.navigation.featurerotuer

import com.ploddasha.cinemashiftapp.confirmation.ConfirmationRoute
import com.ploddasha.cinemashiftapp.confirmation.presentation.ConfirmationRouter
import com.ploddasha.cinemashiftapp.navigation.GlobalRouter
import com.ploddasha.cinemashiftapp.personinput.presentation.PersonInputRouter

class PersonInputRouterImpl(private val globalRouter: GlobalRouter) : PersonInputRouter {

    override fun goBack() {
        globalRouter.pop()
    }

}