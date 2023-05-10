package com.sooyoungjang.superbaby.main.ui

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.sooyoungjang.SuperBabyNavigationBar
import com.sooyoungjang.SuperBabyNavigationBarItem
import com.sooyoungjang.component.SuperBabyLoading
import com.sooyoungjang.date_picker.BaseDatePickerDialog
import com.sooyoungjang.superbaby.main.MainViewModel
import com.sooyoungjang.superbaby.main.contract.MainUiState
import com.sooyoungjang.superbaby.main.navigation.SuperBabyNavHost
import com.sooyoungjang.superbaby.intro.IntroRoute
import com.sooyoungjang.top_bar.SuperBabyTopAppBar
import io.reactivex.rxjava3.disposables.CompositeDisposable

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperBabyApp(
    mainViewModel: MainViewModel,
    appState: SuperBabyState = rememberSuperBabyState(),
    compositeDisposable: CompositeDisposable,
    onLauncherFinished: () -> Unit
) {

    val state by mainViewModel.container.stateFlow.collectAsStateWithLifecycle()
    val context = LocalContext.current

    when (state.uiState) {
        MainUiState.Intro -> IntroRoute(disposables = compositeDisposable)
        MainUiState.Error -> Toast.makeText(context, "error 가 발생 하였습니다. 로그인을 다시 해 주세요.", Toast.LENGTH_SHORT).show()
        MainUiState.Empty -> Toast.makeText(context, "데이터가 없습니다.", Toast.LENGTH_SHORT).show()
        MainUiState.Loading -> MainLoading()
        is MainUiState.Success -> MainScreen(appState = appState)
    }

    onLauncherFinished.invoke()
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(
    appState: SuperBabyState = rememberSuperBabyState(),
) {

    if (appState.shouldShowSettingsDialog) {
        BaseDatePickerDialog(
            datePickerState = appState.datePickerState,
            onDismiss = { appState.setShowSettingsDialog(false) },
        )
    }

    Scaffold(
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
            Column(Modifier.fillMaxSize()) {
                // Show the top app bar on top level destinations.
                val destination = appState.currentTopLevelDestination
                if (destination != null && destination.screenRoute != BottomGraphConst.ChatGpt) {
                    SuperBabyTopAppBar(
                        datePickerState = appState.datePickerState,
                        onActionClick = { appState.setShowSettingsDialog(true) }
                    )
                }
                SuperBabyNavHost(appState.navController)
            }
        }
    }
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
                    Text(destination.text)
                }
            )
        }
    }
}

@Composable
private fun MainLoading(
    modifier:Modifier = Modifier
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SuperBabyLoading(
            modifier = modifier
        )
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false
