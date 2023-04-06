package com.sooyoungjang.superbaby.main

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sooyoungjang.superbaby.chatgpt.ChatGptRoute
import com.sooyoungjang.superbaby.home.HomeScreen
import com.sooyoungjang.superbaby.integral.IntegralScreen
import com.sooyoungjang.superbaby.navigation.BottomNavItem

@Composable
fun HomeNavGraph() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            NavigationBar(modifier = Modifier.height(37.dp)) {
                BottomNavItem.values().forEach { item ->
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val selected = navBackStackEntry?.destination?.hierarchy?.any { it.route == item.screenRoute } == true
                    LazyBottomNavigationItem(navController, selected, item)
                }
            }
        }
    ) { innerPadding ->
        NavHost(navController = navController, startDestination = BottomNavItem.Home.screenRoute, Modifier.padding(innerPadding)) {
            composable(BottomNavItem.Home.screenRoute) {
                HomeScreen()
            }
            composable(BottomNavItem.ChatGpt.screenRoute) {
                ChatGptRoute()
            }
            composable(BottomNavItem.Integral.screenRoute) {
                IntegralScreen()
            }
        }
    }
}

@Composable
private fun RowScope.LazyBottomNavigationItem(
    navController: NavHostController,
    selected: Boolean,
    item: BottomNavItem,
) {
    NavigationBarItem(
        selected = selected,
        icon = {
            Icon(painter = if (selected) painterResource(id = item.selectIcon) else painterResource(id = item.icon),
                contentDescription = item.screenRoute,
                tint = Color.Unspecified)
        },
        onClick = {
            navController.navigate(item.screenRoute) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        }
    )
}