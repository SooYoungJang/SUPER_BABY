package com.sooyoungjang.superbaby.intro.pager

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.Popup
import com.sooyoungjang.component.SuperBabySignDialog
import com.sooyoungjang.date_picker.BaseDatePickerDialog
import com.sooyoungjang.superbaby.R
import com.sooyoungjang.superbaby.intro.contract.IntroState

@Composable
fun LoginFormScreen(
    state: IntroState
) {

    if (state.shouldShowSnsSignInPopup) {
        SuperBabySignDialog(
            onDismissRequest = { state.setShowSnsSignInDialog(false) },
            properties = DialogProperties(dismissOnClickOutside = true),
        ) {

        }
    }

    if (state.shouldShowSnsSignUpPopup) {
        SuperBabySignDialog(
            onDismissRequest = { state.setShowSnsSignUpDialog(false) },
            properties = DialogProperties(dismissOnClickOutside = true),
        ) {

        }
    }

    Column {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(com.sooyoungjang.ui.R.drawable.icon_bath),
                contentDescription = "banner_image",
                modifier = Modifier
                    .fillMaxSize()
                    .scale(0.5f)
            )
        }

        Box(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp)
        ) {
            Button(onClick = { state.setShowSnsSignInDialog(true) }, modifier = Modifier
                .align(Alignment.Center)
                .scale(1.2f)
                .width(300.dp)
                .padding(start = 16.dp, end = 16.dp) ) {
                Text(text = stringResource(id = R.string.sign_in))
            }
        }

        Box(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 28.dp)
        ) {
            Button(onClick = { state.setShowSnsSignUpDialog(true) }, modifier = Modifier
                .align(Alignment.Center)
                .scale(1.2f)
                .width(300.dp)
                .padding(start = 16.dp, end = 16.dp) ) {
                Text(text = stringResource(id = R.string.sign_up))
            }
        }

    }
}