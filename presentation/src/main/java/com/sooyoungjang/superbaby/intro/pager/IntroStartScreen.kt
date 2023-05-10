package com.sooyoungjang.superbaby.intro.pager

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
import com.sooyoungjang.superbaby.R

@Composable
fun IntroStartScreen(
    onClickStart: () -> Unit = {},
) {

    Column {
        Text(
            modifier = Modifier.padding(32.dp, top = 58.dp),
            text = stringResource(id = R.string.start_title_desc),
            style = MaterialTheme.typography.titleLarge,
        )

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(com.sooyoungjang.ui.R.drawable.icon_bath),
                contentDescription = "banner_image",
                modifier = Modifier.fillMaxSize().scale(0.5f)
            )
        }
        Box(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 58.dp)
        ) {
            Button(onClick = { onClickStart.invoke() }, modifier = Modifier.align(Alignment.Center).scale(1.2f).width(300.dp).padding(start = 16.dp, end = 16.dp) ) {
                Text(text = stringResource(id = R.string.start_title))
            }
        }
    }
}