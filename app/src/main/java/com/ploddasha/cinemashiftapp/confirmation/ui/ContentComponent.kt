package com.ploddasha.cinemashiftapp.confirmation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ploddasha.cinemashiftapp.R

@Composable
fun ContentComponent(
    onContinueBooking: () -> Unit
){
    Column {

        Button(
            onClick = { onContinueBooking() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp)
        ) {
            Text(text = stringResource(R.string.continue_button))
        }
    }

}