package com.sooyoungjang.superbaby.contract

import com.sooyoungjang.superbaby.navigation.BottomNavItem

data class MainState(
    val isLoading: Boolean = true,
    val bottomNavItems: List<BottomNavItem> = listOf()
)

sealed interface MainSideEffect {

}