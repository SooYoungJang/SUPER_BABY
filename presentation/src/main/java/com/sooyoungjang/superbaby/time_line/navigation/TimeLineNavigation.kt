package com.sooyoungjang.superbaby.time_line.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sooyoungjang.superbaby.time_line.TimeLineRoute

const val timeLineNavigationRoute = "timeline_route"

fun NavController.navigateToTimeLine(navOptions: NavOptions? = null) {
    this.navigate(timeLineNavigationRoute, navOptions)
}

fun NavGraphBuilder.timeLineScreen() {
    composable(route = timeLineNavigationRoute) {
        TimeLineRoute()
    }
}
