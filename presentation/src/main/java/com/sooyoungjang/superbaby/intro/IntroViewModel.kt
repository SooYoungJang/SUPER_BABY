package com.sooyoungjang.superbaby.intro

import androidx.lifecycle.ViewModel
import com.kakao.sdk.user.UserApiClient
import com.kakao.sdk.user.rx
import com.navercorp.nid.NaverIdLoginSDK
import com.sooyoungjang.superbaby.intro.contract.IntroPages
import com.sooyoungjang.superbaby.intro.contract.IntroSideEffect
import com.sooyoungjang.superbaby.intro.contract.IntroState
import com.sooyoungjang.superbaby.intro.contract.IntroUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class IntroViewModel @Inject constructor(
    private val compositeDisposable: CompositeDisposable
) : ViewModel(), ContainerHost<IntroState, IntroSideEffect> {
    override val container: Container<IntroState, IntroSideEffect> = container(
        initialState = IntroState()
    ) {
        prepareData()
    }


    private fun prepareData() = intent {
        reduce {
            state.copy(uiState = IntroUiState.Success(currentPageNum = IntroPages.Start.ordinal, pages = IntroPages.values().toList()))
        }
    }

    fun startToIntro() = intent {
        reduce {
            state.copy(uiState = IntroUiState.Success(currentPageNum = IntroPages.LoginForm.ordinal, pages = IntroPages.values().toList()) )
        }
    }

    fun emailLogin() = intent {

    }

    fun kakaoLogin() = intent {
        postSideEffect(IntroSideEffect.KakaoLogin)
    }

    fun naverLogin() = intent {
        postSideEffect(IntroSideEffect.NaverLogin)
    }

    fun onBackClick(currentPageNum: Int) = intent {
        reduce {
            state.copy(uiState = IntroUiState.Success(currentPageNum = currentPageNum - 1, pages = IntroPages.values().toList()) )
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}