package com.sooyoungjang.superbaby.intro.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sooyoungjang.superbaby.intro.IntroRoute


const val introNavigationRoute = "intro_route"

fun NavController.navigateToIntro(navOptions: NavOptions? = null) {
    this.navigate(introNavigationRoute, navOptions)
}

fun NavGraphBuilder.introScreen() {
    composable(route = introNavigationRoute) {
//        IntroRoute()
    }
}
