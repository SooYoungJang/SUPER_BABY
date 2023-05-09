package com.sooyoungjang.superbaby.intro

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.sooyoungjang.superbaby.intro.contract.IntroPages
import com.sooyoungjang.superbaby.intro.contract.IntroState
import com.sooyoungjang.superbaby.intro.pager.IntroStartScreen
import com.sooyoungjang.superbaby.intro.pager.LoginFormScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun IntroPager(
    modifier: Modifier = Modifier,
    state: IntroState,
    pagerState: PagerState,
    currentPageNum: Int,
    pages: List<IntroPages>,
    onClickStart: () -> Unit = {},
    onBackClick: (Int) -> Unit = {}
) {

    BackHandler(enabled = pagerState.currentPage > 0) {
        onBackClick.invoke(pagerState.currentPage)
    }

    LaunchedEffect(key1 = currentPageNum) {
        launch {
            pagerState.animateScrollToPage(
                page = (currentPageNum)
            )
        }
    }

    Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        HorizontalPager(
            modifier = modifier.fillMaxSize(),
            count = pages.count(),
            state = pagerState,

        ) { index ->
            when(pages[index]) {
                IntroPages.Start -> IntroStartScreen(onClickStart = onClickStart)
                IntroPages.LoginForm -> LoginFormScreen(state = state)
            }
        }
    }

}
