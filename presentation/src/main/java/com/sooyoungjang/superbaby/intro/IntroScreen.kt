package com.sooyoungjang.superbaby.intro

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.google.firebase.database.DatabaseReference
import com.kakao.sdk.user.UserApiClient
import com.kakao.sdk.user.rx
import com.navercorp.nid.NaverIdLoginSDK
import com.navercorp.nid.oauth.NidOAuthLogin
import com.navercorp.nid.oauth.OAuthLoginCallback
import com.navercorp.nid.profile.NidProfileCallback
import com.navercorp.nid.profile.data.NidProfileResponse
import com.sooyoungjang.component.SuperBabyLoading
import com.sooyoungjang.superbaby.intro.contract.IntroSideEffect
import com.sooyoungjang.superbaby.intro.contract.IntroState
import com.sooyoungjang.superbaby.intro.contract.IntroUiState
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers


@Composable
internal fun IntroRoute(
    modifier: Modifier = Modifier,
    viewModel: IntroViewModel = hiltViewModel(),
    disposables: CompositeDisposable
) {
    lateinit var database: DatabaseReference

    val state by viewModel.container.stateFlow.collectAsStateWithLifecycle()
    val context = LocalContext.current

//    NidOAuthLogin().callDeleteTokenApi(context, object : OAuthLoginCallback {
//        override fun onSuccess() {
//            //서버에서 토큰 삭제에 성공한 상태입니다.
//        }
//        override fun onFailure(httpStatus: Int, message: String) {
//            // 서버에서 토큰 삭제에 실패했어도 클라이언트에 있는 토큰은 삭제되어 로그아웃된 상태입니다.
//            // 클라이언트에 토큰 정보가 없기 때문에 추가로 처리할 수 있는 작업은 없습니다.
//            Log.d(TAG, "errorCode: ${NaverIdLoginSDK.getLastErrorCode().code}")
//            Log.d(TAG, "errorDesc: ${NaverIdLoginSDK.getLastErrorDescription()}")
//        }
//        override fun onError(errorCode: Int, message: String) {
//            // 서버에서 토큰 삭제에 실패했어도 클라이언트에 있는 토큰은 삭제되어 로그아웃된 상태입니다.
//            // 클라이언트에 토큰 정보가 없기 때문에 추가로 처리할 수 있는 작업은 없습니다.
//            onFailure(errorCode, message)
//        }
//    })

    LaunchedEffect(viewModel) {
        viewModel.container.sideEffectFlow.collect() {
            when (it) {
                IntroSideEffect.EmailLogin -> {}
                IntroSideEffect.KakaoLogin -> kakaoLogin(context, disposables, viewModel::getUserInfo)
                IntroSideEffect.NaverLogin -> naverLogin(context)
            }
        }
    }

    IntroScreen(
        modifier = modifier,
        state = state,
        onClickStart = viewModel::startToIntro,
        onBackClick = viewModel::onBackClick,
        onClickEmail = viewModel::emailLogin,
        onClickKakao = viewModel::kakaoLogin,
        onClickNaver = viewModel::naverLogin
    )
}


@OptIn(ExperimentalPagerApi::class)
@Composable
internal fun IntroScreen(
    modifier: Modifier = Modifier,
    state: IntroState,
    onClickStart: () -> Unit = {},
    onBackClick: (Int) -> Unit = {},
    onClickEmail: () -> Unit,
    onClickKakao: () -> Unit,
    onClickNaver: () -> Unit
) {

    when (val uiState = state.uiState) {

        IntroUiState.Loading -> Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SuperBabyLoading(
                modifier = modifier
            )
        }

        is IntroUiState.Success -> {
            val pagerState = rememberPagerState(initialPage = uiState.currentPageNum)

            IntroPager(
                modifier = modifier,
                pagerState = pagerState,
                state = state,
                currentPageNum = uiState.currentPageNum,
                pages = uiState.pages,
                onClickStart = onClickStart,
                onBackClick = onBackClick,
                onClickEmail = onClickEmail,
                onClickKakao = onClickKakao,
                onClickNaver = onClickNaver
            )
        }
    }

}

private fun kakaoLogin(context: Context, disposables: CompositeDisposable, getUserInfo: () -> Unit) {
    Single.just(UserApiClient.instance.isKakaoTalkLoginAvailable(context))
        .flatMap { available ->
            if (available) UserApiClient.rx.loginWithKakaoTalk(context)
            else UserApiClient.rx.loginWithKakaoAccount(context)
        }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ getUserInfo.invoke() }, { Log.d("Test","eddy test ${it.message}") })
        .addTo(disposables)
}

private fun naverLogin(context: Context) {
    NaverIdLoginSDK.authenticate(context, object : OAuthLoginCallback {

        override fun onSuccess() {
            NidOAuthLogin().callProfileApi(object : NidProfileCallback<NidProfileResponse> {
                override fun onSuccess(result: NidProfileResponse) {


                    Log.i(TAG, "로그인 성공 ${result.profile?.email} ")
                    Log.i(TAG, "로그인 성공 ${result.profile?.birthYear} ")
                    Log.i(TAG, "로그인 성공 ${result.profile?.birthday} ")
                    Log.i(TAG, "로그인 성공 ${result.profile?.nickname} ")
                }

                override fun onFailure(httpStatus: Int, message: String) {
                    TODO("Not yet implemented")
                }

                override fun onError(errorCode: Int, message: String) {
                    TODO("Not yet implemented")
                }

            })
        }

        override fun onFailure(httpStatus: Int, message: String) {
            val errorCode = NaverIdLoginSDK.getLastErrorCode().code
            val errorDescription = NaverIdLoginSDK.getLastErrorDescription()
            Toast.makeText(context, "errorCode:$errorCode, errorDesc:$errorDescription", Toast.LENGTH_SHORT).show()
        }

        override fun onError(errorCode: Int, message: String) {
            onFailure(errorCode, message)
        }

    })
}