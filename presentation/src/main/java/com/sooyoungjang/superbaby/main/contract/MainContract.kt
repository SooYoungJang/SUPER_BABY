package com.sooyoungjang.superbaby.main.contract

data class MainState(
    val isLoading: Boolean = true,
)

sealed interface MainSideEffect {

}