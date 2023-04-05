package com.sooyoungjang.superbaby.main

import androidx.lifecycle.ViewModel
import com.sooyoungjang.superbaby.main.contract.MainSideEffect
import com.sooyoungjang.superbaby.main.contract.MainState
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel(), ContainerHost<MainState, MainSideEffect> {

    override val container: Container<MainState, MainSideEffect> = container(MainState()) { prepareData() }

    private fun prepareData() = intent {
        reduce {
            state.copy(isLoading = false)
        }
    }

}