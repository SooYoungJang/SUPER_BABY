package com.sooyoungjang.superbaby.main.contract

import com.sooyoungjang.superbaby.navigation.BottomNavItem

data class MainState(
    val isLoading: Boolean = true,
)

sealed interface MainSideEffect {

}