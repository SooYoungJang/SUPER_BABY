package com.sooyoungjang.superbaby.main.contract

data class MainState(
    val uiState: MainUiState = MainUiState.Loading
)

sealed interface MainUiState {

    object Intro: MainUiState
    object Loading : MainUiState

    object Empty: MainUiState

    object Error: MainUiState
    data class Success(
        val isLogin: Boolean
    ) : MainUiState
}

sealed interface MainSideEffect {

}

