package com.sooyoungjang.superbaby.navigation.bottom

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sooyoungjang.superbaby.chatgpt.ChatGptRoute
import com.sooyoungjang.superbaby.home.RecordScreen
import com.sooyoungjang.superbaby.integral.IntegralScreen
import com.sooyoungjang.superbaby.time_line.TimeLineScreen
import com.sooyoungjang.top_bar.TopBar

@Composable
fun HomeNavGraph() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    Scaffold(
        topBar = {
            when (navBackStackEntry?.destination?.route) {
                BottomNavItem.ChatGpt.screenRoute -> {}
                else -> TopBar()
            }
        },
        bottomBar = {
            NavigationBar() {
                BottomNavItem.values().forEach { item ->
                    val selected = navBackStackEntry?.destination?.hierarchy?.any { it.route == item.screenRoute } == true
                    LazyBottomNavigationItem(navController, selected, item)
                }
            }
        }
    ) { innerPadding ->
        NavHost(navController = navController, startDestination = BottomNavItem.Record.screenRoute, Modifier.padding(innerPadding)) {
            composable(BottomNavItem.Record.screenRoute) {
                RecordScreen()
            }
            composable(BottomNavItem.TimeLine.screenRoute) {
                TimeLineScreen()
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
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                Icon(painter = if (selected) painterResource(id = item.selectIcon) else painterResource(id = item.icon),
                    contentDescription = item.screenRoute,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .fillMaxHeight(0.4f)
                        .aspectRatio(1f)
                )
            }
        },
        alwaysShowLabel = false,
        label = { Text(modifier = Modifier.padding(top = 66.dp), text = item.text, maxLines = 1, overflow = TextOverflow.Ellipsis, softWrap = false) },
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