package com.ploddasha.cinemashiftapp.seatselection.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ploddasha.cinemashiftapp.schedule.domain.entity.PlaceItem

@Composable
fun ChooseSeatComponent(
    seats: List<PlaceItem>,
    selectedColumn: Int,
    onSeatSelected: (Int) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val icon = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown

    Box(
        modifier = Modifier
            .clickable { expanded = !expanded }
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val selectedSeatText = seats.getOrNull(selectedColumn)?.let { seat ->
                "${selectedColumn + 1}, ${seat.price} Р, ${seat.type}"
            } ?: ""

            Text(text = selectedSeatText)
            Icon(imageVector = icon, contentDescription = null)
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            seats.forEachIndexed { index, row ->
                DropdownMenuItem(
                    text = {
                        Text(text = "${index + 1}, ${row.price} Р, ${row.type}")
                           },
                    onClick = {
                        onSeatSelected(index)
                        expanded = false
                    }
                )
            }
        }
    }

}