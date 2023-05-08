package com.sooyoungjang.superbaby.tutorial

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
internal fun TutorialRoute(
    viewModel: TutorialViewModel = hiltViewModel()
) {

    TutorialScreen()
}


@Composable
internal fun TutorialScreen() {

}