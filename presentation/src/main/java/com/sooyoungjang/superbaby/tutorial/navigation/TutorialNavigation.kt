package com.sooyoungjang.superbaby.tutorial.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sooyoungjang.superbaby.tutorial.TutorialRoute


const val tutorialNavigationRoute = "tutorial_route"

fun NavController.navigateToTutorial(navOptions: NavOptions? = null) {
    this.navigate(tutorialNavigationRoute, navOptions)
}

fun NavGraphBuilder.tutorialScreen() {
    composable(route = tutorialNavigationRoute) {
        TutorialRoute()
    }
}
