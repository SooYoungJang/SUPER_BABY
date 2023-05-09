package com.sooyoungjang.datastore

import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
    fun getUserPrefs() : Flow<UserPreferences>

    suspend fun setUserIsSeenIntro(isSeen: Boolean)

    suspend fun setUserIsLogin(isLogin: Boolean)

}