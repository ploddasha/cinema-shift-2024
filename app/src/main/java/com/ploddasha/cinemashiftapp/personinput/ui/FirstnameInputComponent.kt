package com.ploddasha.cinemashiftapp.personinput.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ploddasha.cinemashiftapp.R
import com.ploddasha.cinemashiftapp.personinput.presentation.PersonInputViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstnameInputComponent(
    personInputViewModel: PersonInputViewModel
) {
    val uiState by personInputViewModel.uiState.collectAsState()

    Column {
        TextField(
            value = uiState.firstname,
            onValueChange = { personInputViewModel.updateFirstname(it) },
            label = { Text(text = stringResource(R.string.firstname)) },
            isError = !uiState.isFirstnameValid,
            modifier = Modifier.fillMaxWidth()
        )
        if (!uiState.isFirstnameValid) {
            Text(
                text = if (uiState.firstname.isBlank()) {
                    stringResource(R.string.field_is_required_error)
                } else {
                    stringResource(R.string.invalid_firstname_message)
                },
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}