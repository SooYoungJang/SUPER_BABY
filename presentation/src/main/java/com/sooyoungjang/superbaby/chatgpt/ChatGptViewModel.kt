package com.sooyoungjang.superbaby.chatgpt

import androidx.lifecycle.ViewModel
import com.sooyoungjang.superbaby.chatgpt.contract.ChatGptSideEffect
import com.sooyoungjang.superbaby.chatgpt.contract.ChatGptState
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class ChatGptViewModel @Inject constructor() : ViewModel(), ContainerHost<ChatGptState, ChatGptSideEffect> {

    override val container: Container<ChatGptState, ChatGptSideEffect> = container(ChatGptState()) { prepareData() }

    private fun prepareData() = intent {

    }

}