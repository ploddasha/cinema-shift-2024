package com.ploddasha.cinemashiftapp.confirmation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ploddasha.cinemashiftapp.confirmation.presentation.ConfirmationViewModel

@Composable
fun ConfirmationScreen(
    confirmationViewModel: ConfirmationViewModel
){
    val selectedData = confirmationViewModel.fakeSelectedData

    Column {

        ContentComponent(
            selectedData = selectedData,
            onContinueBooking = confirmationViewModel::openPersonInput
        )
    }

}