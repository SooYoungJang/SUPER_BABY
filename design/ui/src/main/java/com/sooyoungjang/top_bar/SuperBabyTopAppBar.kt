package com.sooyoungjang.top_bar

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.sooyoungjang.date_picker.BaseDatePickerDialog
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import kotlin.time.Duration.Companion.days

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperBabyTopAppBar(
    modifier: Modifier = Modifier,
    datePickerState: DatePickerState,
    onActionClick: () -> Unit = {},
) {

    val date = datePickerState.selectedDateMillis?.let {
        Instant.ofEpochMilli(it).atZone(ZoneId.systemDefault()).toLocalDate()
    }?.format(DateTimeFormatter.ISO_LOCAL_DATE).toString()

    CenterAlignedTopAppBar(
        title = {
            TextButton(
                onClick = { onActionClick.invoke() }
            ) {
                Text(text = date)
            }
        }
    )
}