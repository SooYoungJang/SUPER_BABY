package com.sooyoungjang.superbaby.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.sooyoungjang.superbaby.chatgpt.navigation.chatGptScreen
import com.sooyoungjang.superbaby.integral.navigation.integralScreen
import com.sooyoungjang.superbaby.record.navigation.recordScreen
import com.sooyoungjang.superbaby.time_line.navigation.timeLineScreen
import com.sooyoungjang.superbaby.intro.navigation.introNavigationRoute

@Composable
fun SuperBabyNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = introNavigationRoute,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        recordScreen()
        timeLineScreen()
        chatGptScreen()
        integralScreen()
    }
}