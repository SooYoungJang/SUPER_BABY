package com.sooyoungjang.superbaby.main

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.kakao.sdk.common.util.Utility
import com.sooyoungjang.superbaby.main.ui.SuperBabyApp
import com.sooyoungjang.theme.SuperBabyTheme
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel: MainViewModel by viewModels()
    private var keepSplashScreen = true

    @Inject
    lateinit var compositeDisposable: CompositeDisposable

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().setKeepOnScreenCondition {
            keepSplashScreen
        }

        setContent {
            SuperBabyTheme {
                SuperBabyApp(mainViewModel = viewModel, compositeDisposable = compositeDisposable) {
                    keepSplashScreen = false
                }
            }

        }
    }

}
