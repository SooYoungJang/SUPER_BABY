package com.sooyoungjang.superbaby.main.ui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.sooyoungjang.SuperBabyNavigationBar
import com.sooyoungjang.SuperBabyNavigationBarItem
import com.sooyoungjang.superbaby.main.MainViewModel
import com.sooyoungjang.superbaby.main.navigation.SuperBabyNavHost

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SuperBabyApp(
    mainViewModel: MainViewModel,
    appState: SuperBabyState = rememberSuperBabyState(),
    onLauncherFinished: () -> Unit,
) {
    Scaffold(
//        topBar = {
//            when (navBackStackEntry?.destination?.route) {
//                BottomNavItem.ChatGpt.screenRoute -> {}
//                else -> TopBar()
//            }
//        },
        bottomBar = {
            SuperBabyBottomBar(
                destinations = appState.topLevelDestinations,
                onNavigateToDestination = appState::navigateToTopLevelDestination,
                currentDestination = appState.currentDestination,
                modifier = Modifier.testTag("NiaBottomBar"),
            )
        }
    ) { padding ->
        Row(
            Modifier
                .fillMaxSize()
                .padding(padding)
                .consumeWindowInsets(padding)
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(
                        WindowInsetsSides.Horizontal,
                    ),
                ),
        ) {
            SuperBabyNavHost(appState.navController)
        }
    }


    onLauncherFinished.invoke()
}


@Composable
private fun SuperBabyBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
) {
    SuperBabyNavigationBar(
        modifier = modifier,
    ) {
        destinations.forEach { destination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            SuperBabyNavigationBarItem(
                alwaysShowLabel = false,
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                selectedIcon = {
                    Icon(
                        painter = painterResource(id = destination.selectIcon), contentDescription = destination.screenRoute, tint = Color.Unspecified,
                        modifier = Modifier
                            .fillMaxHeight(0.4f)
                            .aspectRatio(1f)
                    )
                },
                icon = {
                    Icon(
                        painter = painterResource(id = destination.icon), contentDescription = destination.screenRoute, tint = Color.Unspecified,
                        modifier = Modifier
                            .fillMaxHeight(0.4f)
                            .aspectRatio(1f)
                    )
                },
                label = {
                    Text(destination.screenRoute) },
            )
        }
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        Log.d("test","alkjlk ${destination.name}  ::: ${it.route}")
        it.route?.contains(destination.name, true) ?: false
    } ?: false
