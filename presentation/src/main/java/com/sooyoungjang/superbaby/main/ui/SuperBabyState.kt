package com.sooyoungjang.superbaby.main.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import androidx.tracing.trace
import com.sooyoungjang.superbaby.chatgpt.navigation.chatGptNavigationRoute
import com.sooyoungjang.superbaby.chatgpt.navigation.navigateToChatGpt
import com.sooyoungjang.superbaby.integral.navigation.integralNavigationRoute
import com.sooyoungjang.superbaby.integral.navigation.navigateToIntegral
import com.sooyoungjang.superbaby.record.RecordRoute
import com.sooyoungjang.superbaby.record.navigation.navigateToRecord
import com.sooyoungjang.superbaby.record.navigation.recordNavigationRoute
import com.sooyoungjang.superbaby.time_line.navigation.navigateToTimeLine
import com.sooyoungjang.superbaby.time_line.navigation.timeLineNavigationRoute
import kotlinx.coroutines.CoroutineScope
import java.time.LocalDate
import java.time.ZoneOffset


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun rememberSuperBabyState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
    datePickerState: DatePickerState = rememberDatePickerState(
        initialDisplayMode = DisplayMode.Picker,
        yearRange = IntRange(2023, 2030),
        initialSelectedDateMillis =
        LocalDate.now()
            .atStartOfDay()
            .toEpochSecond(ZoneOffset.UTC).toMillis(),
        initialDisplayedMonthMillis =
        LocalDate.now()
            .atStartOfDay()
            .toEpochSecond(ZoneOffset.UTC).toMillis()
    ),
): SuperBabyState {
    return remember(navController, coroutineScope, datePickerState) {
        SuperBabyState(navController, coroutineScope, datePickerState)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Stable
class SuperBabyState(
    val navController: NavHostController,
    val coroutineScope: CoroutineScope,
    val datePickerState: DatePickerState,
) {

    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            recordNavigationRoute -> TopLevelDestination.Record
            timeLineNavigationRoute -> TopLevelDestination.TimeLine
            chatGptNavigationRoute -> TopLevelDestination.ChatGpt
            integralNavigationRoute -> TopLevelDestination.Integral
            else -> null
        }

    var shouldShowSettingsDialog by mutableStateOf(false)
        private set

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

    fun setShowSettingsDialog(shouldShow: Boolean) {
        shouldShowSettingsDialog = shouldShow
    }
}

private fun Long.toMillis() = this * 1000