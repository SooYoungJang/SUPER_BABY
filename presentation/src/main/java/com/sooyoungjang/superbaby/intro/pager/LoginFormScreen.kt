package com.sooyoungjang.superbaby.intro.pager

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.navercorp.nid.oauth.view.NidOAuthLoginButton
import com.sooyoungjang.component.SuperBabySignDialog
import com.sooyoungjang.superbaby.R
import com.sooyoungjang.superbaby.intro.contract.IntroState

@Composable
fun LoginFormScreen(
    state: IntroState,
    onClickEmail: () -> Unit,
    onClickKakao: () -> Unit,
    onClickNaver: () -> Unit
) {

    if (state.shouldShowSnsSignInPopup) {
        SuperBabySignDialog(
            onDismissRequest = { state.setShowSnsSignInDialog(false) }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {

                Spacer(modifier = Modifier.padding(top = 5.dp))

                Button(onClick = { onClickEmail.invoke() }, modifier = Modifier.scale(1.2f).width(300.dp).padding(start = 16.dp, end = 16.dp) ) {
                    Text(text = stringResource(id = R.string.start_title))
                }

                IconButton(onClick = { onClickKakao.invoke() }, modifier = Modifier.scale(1.6f).width(300.dp).padding(start = 16.dp, end = 16.dp) ) {
                    Icon(
                        painter = painterResource(id = com.sooyoungjang.ui.R.drawable.kakao_login_large_wide),
                        contentDescription = "kakao icon",
                        tint = Color.Unspecified
                    )
                }

                IconButton(onClick = { onClickNaver.invoke() }, modifier = Modifier.scale(1.6f).width(300.dp).padding(start = 16.dp, end = 16.dp) ) {
                    Icon(
                        painter = painterResource(id = com.sooyoungjang.ui.R.drawable.naver_login_complete),
                        contentDescription = "kakao icon",
                        tint = Color.Unspecified
                    )
                }

                Spacer(modifier = Modifier.padding(bottom = 5.dp))

            }
        }
    }

    if (state.shouldShowSnsSignUpPopup) {
        SuperBabySignDialog(
            onDismissRequest = { state.setShowSnsSignUpDialog(false) },
        ) {
            Column {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = com.sooyoungjang.ui.R.drawable.kakao_login_large_wide), contentDescription = "kakao_login")
                }
            }
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
            Button(
                onClick = { state.setShowSnsSignInDialog(true) }, modifier = Modifier
                    .align(Alignment.Center)
                    .scale(1.2f)
                    .width(300.dp)
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Text(text = stringResource(id = R.string.sign_in))
            }
        }

        Box(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 28.dp)
        ) {
            Button(
                onClick = { state.setShowSnsSignUpDialog(true) }, modifier = Modifier
                    .align(Alignment.Center)
                    .scale(1.2f)
                    .width(300.dp)
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Text(text = stringResource(id = R.string.sign_up))
            }
        }

    }
}