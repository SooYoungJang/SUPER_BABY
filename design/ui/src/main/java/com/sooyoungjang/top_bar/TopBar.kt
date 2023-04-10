package com.sooyoungjang.top_bar

import android.annotation.SuppressLint
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.sooyoungjang.date_picker.BaseDatePickerDialog

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
) {
    val datePickerState = rememberDatePickerState(initialDisplayMode = DisplayMode.Picker)
    val openDialog = remember { mutableStateOf(false) }

    CenterAlignedTopAppBar(title = {
        TextButton(onClick = {
            openDialog.value = true

        }) {
            Text(text = "sdf")
        }
    })

    if (openDialog.value) {
        BaseDatePickerDialog(modifier, datePickerState, openDialog)
    }

}



