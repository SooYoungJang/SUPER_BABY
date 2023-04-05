package com.sooyoungjang.superbaby.chatgpt

import android.annotation.SuppressLint
import android.os.Build
import android.webkit.WebSettings
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.web.AccompanistWebChromeClient
import com.google.accompanist.web.AccompanistWebViewClient
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState
import com.sooyoungjang.superbaby.chatgpt.contract.ChatGptState

@Composable
fun ChatGptRoute(
    onTopicClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
    viewModel: ChatGptViewModel = hiltViewModel(),
) {

    val state by viewModel.container.stateFlow.collectAsStateWithLifecycle()
    val webViewClient = AccompanistWebViewClient()
    val webChromeClient = AccompanistWebChromeClient()

//    LaunchedEffect(viewModel) {
//        viewModel.container.sideEffectFlow.collect {
//            when (it) {
//                is InitSideEffect.Completed -> onCompleted()
//            }
//        }
//    }

    ChatGptScreen(
        modifier = modifier,
        state = state,
        onTopicClick = onTopicClick,
        webViewClient,
        webChromeClient
    )
}


@SuppressLint("SetJavaScriptEnabled")
@Composable
fun ChatGptScreen(
    modifier: Modifier = Modifier,
    state: ChatGptState,
    onTopicClick: (() -> Unit)? = null,
    webViewClient: AccompanistWebViewClient,
    webChromeClient: AccompanistWebChromeClient,
) {
    val webViewState =
        rememberWebViewState(
            url = "https://chat.openai.com",
            additionalHttpHeaders = emptyMap()
        )

    val USER_AGENT = "(Android " + Build.VERSION.RELEASE + ") Chrome/110.0.5481.63 Mobile";

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        WebView(state = webViewState, modifier = modifier.fillMaxSize() ,client = webViewClient, chromeClient = webChromeClient, onCreated = { webView ->
            with(webView) {
                settings.run {
                    userAgentString = USER_AGENT
                    javaScriptEnabled = true
                    domStorageEnabled = true
                    javaScriptCanOpenWindowsAutomatically = false
                    cacheMode = WebSettings.LOAD_DEFAULT
                }
            }
        })
    }
}
