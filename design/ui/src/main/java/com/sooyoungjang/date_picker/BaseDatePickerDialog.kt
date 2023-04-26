package com.sooyoungjang.date_picker

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.DialogProperties

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseDatePickerDialog(
    modifier: Modifier = Modifier,
    datePickerState: DatePickerState,
    openDialog: MutableState<Boolean>,
) {

    DatePickerDialog(
        properties = DialogProperties(dismissOnClickOutside = false),
        onDismissRequest = {
            openDialog.value = false
        }, confirmButton = {
            TextButton(
                onClick = { openDialog.value = false },
                enabled = true
            ) {
                Text("OK")
            }
        }) {
        DatePicker(state = datePickerState, showModeToggle = false)
    }
}