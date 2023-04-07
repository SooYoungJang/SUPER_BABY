package com.sooyoungjang.superbaby.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sooyoungjang.superbaby.inii_setting.InitUserSettingNavGraph
import com.sooyoungjang.superbaby.inii_setting.InitUserSettingNavItem
import com.sooyoungjang.superbaby.navigation.BottomNavItem
import com.sooyoungjang.superbaby.navigation.HomeNavGraph

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val startDestination = BottomNavItem.Record.screenRoute
    NavHost(navController, startDestination = startDestination) {
        composable(route = InitUserSettingNavItem.InitUser.screenRoute) {
            InitUserSettingNavGraph()
        }
        composable(route = BottomNavItem.Record.screenRoute) {
            HomeNavGraph()
        }
//        composable(route = SettingNavItem.Setting.screenRoute) {
//            SettingNavGraph()
//        }
    }
}