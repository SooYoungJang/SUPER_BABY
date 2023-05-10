package com.sooyoungjang.data.datastore.local

import android.util.Log
import androidx.datastore.core.DataStore
import com.sooyoungjang.datastore.UserPreferences
import kotlinx.coroutines.flow.Flow
import java.io.IOException
import javax.inject.Inject

class DatastoreLocalDataSourceImpl @Inject constructor(
    private val dataStore: DataStore<UserPreferences>
) : DatastoreLocalDataSource {

    override fun getUserPrefs(): Flow<UserPreferences> = dataStore.data

    override suspend fun setUserIsSeenIntro(isSeen: Boolean) {
        try {
            dataStore.updateData { it.copy(isSeenIntro = isSeen) }
        } catch (ioException: IOException) {
            Log.e("SuperBabyPreferences", "Failed to update user preferences", ioException)
        }
    }

    override suspend fun setUserIsLogin(isLogin: Boolean) {
        try {
            dataStore.updateData { it.copy(isLogin = isLogin) }
        } catch (ioException: IOException) {
            Log.e("SuperBabyPreferences", "Failed to update user preferences", ioException)
        }
    }
}