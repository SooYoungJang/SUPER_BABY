package com.sooyoungjang.superbaby.main.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import androidx.tracing.trace
import com.sooyoungjang.superbaby.chatgpt.navigation.navigateToChatGpt
import com.sooyoungjang.superbaby.integral.navigation.navigateToIntegral
import com.sooyoungjang.superbaby.record.navigation.navigateToRecord
import com.sooyoungjang.superbaby.time_line.navigation.navigateToTimeLine
import kotlinx.coroutines.CoroutineScope


@Composable
fun rememberSuperBabyState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController()
): SuperBabyState {
    return remember(navController, coroutineScope) {
        SuperBabyState(navController, coroutineScope)
    }
}



@Stable
class SuperBabyState(
    val navController: NavHostController,
    val coroutineScope: CoroutineScope
) {

    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().asList()

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        trace("Navigation: ${topLevelDestination.name}") {
            val topLevelNavOptions = navOptions {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }

            when (topLevelDestination) {
                TopLevelDestination.Record -> navController.navigateToRecord(topLevelNavOptions)
                TopLevelDestination.TimeLine -> navController.navigateToTimeLine(topLevelNavOptions)
                TopLevelDestination.ChatGpt -> navController.navigateToChatGpt(topLevelNavOptions)
                TopLevelDestination.Integral -> navController.navigateToIntegral(topLevelNavOptions)
            }
        }
    }
}