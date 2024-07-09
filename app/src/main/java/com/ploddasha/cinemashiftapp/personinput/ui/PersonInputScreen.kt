package com.ploddasha.cinemashiftapp.personinput.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.ploddasha.cinemashiftapp.personinput.presentation.PersonInputViewModel

@Composable
fun PersonInputScreen(
    personInputViewModel: PersonInputViewModel
){
    Column {
        ContentComponent()
    }

}