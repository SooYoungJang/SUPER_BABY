package com.sooyoungjang.superbaby.integral.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sooyoungjang.superbaby.record.RecordRoute

const val integralNavigationRoute = "integral_route"

fun NavController.navigateToIntegral(navOptions: NavOptions? = null) {
    this.navigate(integralNavigationRoute, navOptions)
}

fun NavGraphBuilder.integralScreen() {
    composable(route = integralNavigationRoute) {
        RecordRoute()
    }
}
