package com.ploddasha.cinemashiftapp.personinput.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ploddasha.cinemashiftapp.R
import com.ploddasha.cinemashiftapp.personinput.presentation.PersonInputViewModel

@Composable
fun ContentComponent(
    personInputViewModel: PersonInputViewModel
){
    Column (
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ){
        Text(
            text = stringResource(R.string.your_data),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 32.dp),
        )
        LastnameInputComponent(
            personInputViewModel = personInputViewModel
        )
        FirstnameInputComponent(
            personInputViewModel = personInputViewModel
        )
        FatherNameInputComponent(
            personInputViewModel = personInputViewModel
        )
        PhoneInputComponent(
            personInputViewModel = personInputViewModel
        )

        Button(
            onClick = { /* */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp)
        ) {
            Text(text = stringResource(R.string.continue_button))
        }
    }

}
