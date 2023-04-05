package com.sooyoungjang.superbaby.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sooyoungjang.superbaby.navigation.BottomNavItem

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = BottomNavItem.Home.screenRoute) {
        composable(route = BottomNavItem.Home.screenRoute) {
            HomeGraph()
        }
    }
}