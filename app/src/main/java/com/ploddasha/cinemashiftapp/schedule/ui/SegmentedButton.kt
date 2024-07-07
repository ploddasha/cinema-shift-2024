package com.ploddasha.cinemashiftapp.schedule.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SegmentedButton(
    dates: List<String>,
    onDateSelected: (String) -> Unit
) {
    var selectedDate by remember { mutableStateOf(dates.first()) }
    val scrollState = rememberScrollState()

    Row (
        modifier = Modifier
            .horizontalScroll(scrollState)
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        dates.forEach { date ->
            Text(
                text = date,
                modifier = Modifier
                    .background(
                        if (date == selectedDate) MaterialTheme.colorScheme.primary else Color.Gray,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .clickable {
                        selectedDate = date
                        onDateSelected(date)
                    }
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                color = Color.White
            )
        }
    }
}