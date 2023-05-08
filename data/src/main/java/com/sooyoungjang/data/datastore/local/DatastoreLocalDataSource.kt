package com.sooyoungjang.data.datastore.local

import com.sooyoungjang.datastore.UserPreferences
import kotlinx.coroutines.flow.Flow

interface DatastoreLocalDataSource {
    fun getUserPrefs() : Flow<UserPreferences>

    suspend fun setUserIsSeenTutorial(isSeen: Boolean)

    suspend fun setUserIsLogin(isLogin: Boolean)

}