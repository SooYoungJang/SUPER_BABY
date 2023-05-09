package com

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import com.sooyoungjang.superbaby.BuildConfig
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AndroidApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        KakaoSdk.init(this, BuildConfig.KAKAO_API_KEY)
    }
}