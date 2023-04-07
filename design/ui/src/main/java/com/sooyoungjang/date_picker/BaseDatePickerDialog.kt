package com.sooyoungjang.top_bar

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseDatePickerDialog(datePickerState: DatePickerState) {
    DatePickerDialog(
        onDismissRequest = { }, confirmButton = {
            TextButton(
                onClick = { },
                enabled = true
            ) {
                Text("OK")
            }
        }) {
        DatePicker(state = datePickerState)
    }
}