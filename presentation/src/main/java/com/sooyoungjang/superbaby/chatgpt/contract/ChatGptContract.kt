package com.sooyoungjang.superbaby.chatgpt.contract

data class ChatGptState(
    val isLoading: Boolean = true
)

sealed interface ChatGptSideEffect {

}