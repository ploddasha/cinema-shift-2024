package com.ploddasha.cinemashiftapp.personinput.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ploddasha.cinemashiftapp.R
import com.ploddasha.cinemashiftapp.personinput.presentation.PersonInputViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneInputComponent(
    personInputViewModel: PersonInputViewModel
) {
    val uiState by personInputViewModel.uiState.collectAsState()

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ){
        TextField(
            value = uiState.phone,
            onValueChange = { personInputViewModel.updatePhone(it.filter { char -> char.isDigit() }) },
            label = { Text(text = stringResource(R.string.phone_label)) },
            isError = !uiState.isPhoneValid,
            modifier = Modifier.fillMaxWidth()
        )
        if (!uiState.isPhoneValid) {
            Text(
                text = if (uiState.phone.isBlank()) {
                    stringResource(R.string.field_is_required_error)
                } else {
                    stringResource(R.string.invalid_phone_message)
                },
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}