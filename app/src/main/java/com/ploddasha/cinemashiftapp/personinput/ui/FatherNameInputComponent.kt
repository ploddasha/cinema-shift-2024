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
fun FatherNameInputComponent(
    personInputViewModel: PersonInputViewModel
) {
    val uiState by personInputViewModel.uiState.collectAsState()

    Column {
        TextField(
            value = uiState.fatherName,
            onValueChange = { personInputViewModel.updateFatherName(it) },
            label = { Text(text = stringResource(R.string.fathername)) },
            isError = !uiState.isFatherNameValid,
            modifier = Modifier.fillMaxWidth()
        )
        if (!uiState.isFatherNameValid) {
            Text(
                text = stringResource(R.string.invalid_fathername_message),
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}