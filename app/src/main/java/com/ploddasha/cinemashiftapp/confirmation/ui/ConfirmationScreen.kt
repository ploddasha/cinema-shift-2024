package com.ploddasha.cinemashiftapp.confirmation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.ploddasha.cinemashiftapp.confirmation.presentation.ConfirmationViewModel

@Composable
fun ConfirmationScreen(
    confirmationViewModel: ConfirmationViewModel
){
    Column {
        ContentComponent(
            onContinueBooking = confirmationViewModel::openPersonInput
        )
    }

}