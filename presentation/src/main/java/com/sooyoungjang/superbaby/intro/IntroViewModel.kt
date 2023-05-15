package com.sooyoungjang.superbaby.intro

import android.util.Log
import androidx.lifecycle.ViewModel
import com.kakao.sdk.auth.network.RxAuthOperations
import com.kakao.sdk.common.model.ApiError
import com.kakao.sdk.user.UserApiClient
import com.kakao.sdk.user.rx
import com.sooyoungjang.record.usecase.GetUserUseCase
import com.sooyoungjang.superbaby.intro.contract.IntroPages
import com.sooyoungjang.superbaby.intro.contract.IntroSideEffect
import com.sooyoungjang.superbaby.intro.contract.IntroState
import com.sooyoungjang.superbaby.intro.contract.IntroUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class IntroViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val disposable: CompositeDisposable
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

    private fun isValidateUser(email: String?, nickName: String?, birth: String?) = intent {
        email?.let { getUserUseCase.invoke(email) }
    }

    fun getUserInfo() = intent {
        UserApiClient.rx.me()
            .flatMap { user ->
                val scopes = mutableListOf<String>()
                if (user.kakaoAccount?.emailNeedsAgreement == true) scopes.add("account_email")
                if (user.kakaoAccount?.birthdayNeedsAgreement == true) { scopes.add("birthday") }
                if (user.kakaoAccount?.birthyearNeedsAgreement == true) { scopes.add("birthyear") }
                if (scopes.isNotEmpty()) Single.error(ApiError.fromScopes(scopes))
                else Single.just(user)
            }
            .subscribeOn(Schedulers.io())
            .subscribe({ user ->
                val email = user.kakaoAccount?.email
                val nickName = user.kakaoAccount?.profile?.nickname
                val birth = "${user.kakaoAccount?.birthyear}-${user.kakaoAccount?.birthday}"
                isValidateUser(email, nickName, birth)
            }, {
                Log.d("test","eddy test ${it.message}")
            })
            .addTo(disposable)
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
        disposable.clear()
    }
}