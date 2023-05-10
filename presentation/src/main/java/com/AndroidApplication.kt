package com

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import com.navercorp.nid.NaverIdLoginSDK
import com.sooyoungjang.superbaby.BuildConfig
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AndroidApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        KakaoSdk.init(this, BuildConfig.KAKAO_API_KEY)
        NaverIdLoginSDK.initialize(this, BuildConfig.OAUTH_CLIENT_ID, BuildConfig.OAUTH_CLIENT_SECRET, BuildConfig.OAUTH_CLIENT_NAME)

    }
}