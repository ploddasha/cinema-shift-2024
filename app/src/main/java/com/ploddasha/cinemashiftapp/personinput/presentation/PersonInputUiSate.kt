package com.ploddasha.cinemashiftapp.personinput.presentation

data class PersonInputUiState(
    val firstname: String = "",
    val lastname: String = "",
    val fatherName: String = "",
    val phone: String = "",
    val isFirstnameValid: Boolean = true,
    val isLastnameValid: Boolean = true,
    val isPhoneValid: Boolean = true
)