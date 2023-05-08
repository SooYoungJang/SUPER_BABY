package com.sooyoungjang.superbaby.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sooyoungjang.record.usecase.GetUserPrefUseCase
import com.sooyoungjang.record.usecase.SetUserLoginUseCase
import com.sooyoungjang.record.usecase.SetUserTutorialSeenUseCase
import com.sooyoungjang.superbaby.main.contract.MainSideEffect
import com.sooyoungjang.superbaby.main.contract.MainState
import com.sooyoungjang.superbaby.main.contract.MainUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserPrefUseCase: GetUserPrefUseCase,
    private val setUserTutorialSeenUseCase: SetUserTutorialSeenUseCase,
    private val setUserLoginUseCase: SetUserLoginUseCase
) : ViewModel(), ContainerHost<MainState, MainSideEffect> {

    override val container: Container<MainState, MainSideEffect> = container(MainState()) { prepareData() }

    private fun prepareData() = intent {
        getUserPrefUseCase.invoke()
            .collect {
                when (it.isSeenTutorial) {
                    true -> {
                        when (it.isLogin) {
                            true -> {}
                            false -> {}
                        }
                    }

                    false -> reduce {
                        state.copy(
                            uiState = MainUiState.Tutorial
                        )
                    }
                }

            }
    }

    fun setUserTutorialHaveSeenPref(isSeen: Boolean = false) {
        viewModelScope.launch {
            setUserTutorialSeenUseCase.invoke(isSeen)
        }
    }

    fun setUserLoginPref(isLogin: Boolean = false) {
        viewModelScope.launch {
            setUserLoginUseCase.invoke(isLogin)
        }
    }

}