package com.sooyoungjang.superbaby.chatgpt.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sooyoungjang.superbaby.chatgpt.ChatGptRoute

const val chatGptNavigationRoute = "chatgpt_route"

fun NavController.navigateToChatGpt(navOptions: NavOptions? = null) {
    this.navigate(chatGptNavigationRoute, navOptions)
}

fun NavGraphBuilder.chatGptScreen() {
    composable(route = chatGptNavigationRoute) {
        ChatGptRoute()
    }
}
