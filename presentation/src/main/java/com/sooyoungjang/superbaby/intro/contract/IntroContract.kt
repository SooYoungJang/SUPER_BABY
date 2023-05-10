package com.sooyoungjang.superbaby.intro.contract

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class IntroState(
    val uiState: IntroUiState = IntroUiState.Loading
) {
    var shouldShowSnsSignInPopup by mutableStateOf(false)
        private set

    var shouldShowSnsSignUpPopup by mutableStateOf(false)
        private set

    fun setShowSnsSignInDialog(shouldShow: Boolean) {
        shouldShowSnsSignInPopup = shouldShow
    }

    fun setShowSnsSignUpDialog(shouldShow: Boolean) {
        shouldShowSnsSignUpPopup = shouldShow
    }
}

sealed interface IntroUiState {

    object Loading : IntroUiState

    data class Success(
        val currentPageNum: Int,
        val pages: List<IntroPages>,
    ) : IntroUiState
}


sealed interface IntroSideEffect {

    object EmailLogin: IntroSideEffect
    object KakaoLogin: IntroSideEffect
    object NaverLogin: IntroSideEffect
}


enum class IntroPages {
    Start,
    LoginForm
}