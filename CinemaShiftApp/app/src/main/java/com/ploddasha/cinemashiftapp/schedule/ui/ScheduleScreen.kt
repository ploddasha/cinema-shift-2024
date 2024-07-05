package com.ploddasha.cinemashiftapp.schedule.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ploddasha.cinemashiftapp.R
import com.ploddasha.cinemashiftapp.film.presentation.FilmState
import com.ploddasha.cinemashiftapp.schedule.presentation.ScheduleState
import com.ploddasha.cinemashiftapp.schedule.presentation.ScheduleViewModel


@Composable
fun ScheduleScreen(
    scheduleViewModel: ScheduleViewModel
){
    val scheduleState by scheduleViewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        scheduleViewModel.loadSchedule()
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 8.dp),
            text = stringResource(id = R.string.schedule_title),
            style = MaterialTheme.typography.titleLarge,
        )

        when (val state = scheduleState) {
            is ScheduleState.Initial,
            is ScheduleState.Loading -> com.ploddasha.cinemashiftapp.film.ui.LoadingComponent()

            is ScheduleState.Failure -> com.ploddasha.cinemashiftapp.film.ui.ErrorComponent(
                message = state.message ?: stringResource(id = R.string.error_unknown_error),
                onRetry = { scheduleViewModel.loadSchedule() },
            )

            is ScheduleState.Content -> {
                ContentComponent(
                    schedules = state.schedule
                )

            }
        }
    }

}