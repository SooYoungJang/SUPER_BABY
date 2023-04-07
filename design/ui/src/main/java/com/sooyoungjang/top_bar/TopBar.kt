package com.sooyoungjang.top_bar

import android.annotation.SuppressLint
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
) {
    val datePickerState = rememberDatePickerState()

    CenterAlignedTopAppBar(title = {
        TextButton(onClick = {  }) {
            Text(text = "sdf")
        }
    })
}



