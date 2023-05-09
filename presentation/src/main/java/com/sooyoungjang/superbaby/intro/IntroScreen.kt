package com.sooyoungjang.superbaby.intro

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.sooyoungjang.component.SuperBabyLoading
import com.sooyoungjang.superbaby.intro.contract.IntroState
import com.sooyoungjang.superbaby.intro.contract.IntroUiState


@Composable
internal fun IntroRoute(
    modifier: Modifier = Modifier,
    viewModel: IntroViewModel = hiltViewModel()
) {

    val state by viewModel.container.stateFlow.collectAsStateWithLifecycle()

    IntroScreen(
        modifier = modifier,
        state = state,
        onClickStart = viewModel::onClickStart,
        onBackClick = viewModel::onBackClick
    )
}


@OptIn(ExperimentalPagerApi::class)
@Composable
internal fun IntroScreen(
    modifier: Modifier = Modifier,
    state: IntroState,
    onClickStart: () -> Unit = {},
    onBackClick: (Int) -> Unit = {}
) {

    when (val uiState = state.uiState) {

        IntroUiState.Loading -> Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SuperBabyLoading(
                modifier = modifier
            )
        }

        is IntroUiState.Success -> {
            val pagerState = rememberPagerState(initialPage = uiState.currentPageNum)

            IntroPager(
                modifier = modifier,
                pagerState = pagerState,
                state = state,
                currentPageNum = uiState.currentPageNum,
                pages = uiState.pages,
                onClickStart = onClickStart,
                onBackClick = onBackClick
            )
        }
    }

}