package com.sooyoungjang.superbaby.record.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sooyoungjang.superbaby.record.RecordRoute

const val recordNavigationRoute = "record_route"

fun NavController.navigateToRecord(navOptions: NavOptions? = null) {
    this.navigate(recordNavigationRoute, navOptions)
}

fun NavGraphBuilder.recordScreen() {
    composable(route = recordNavigationRoute) {
        RecordRoute()
    }
}
