package com.sooyoungjang.data.datastore

import com.sooyoungjang.data.datastore.local.DatastoreLocalDataSource
import com.sooyoungjang.datastore.DataStoreRepository
import com.sooyoungjang.datastore.UserPreferences
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataStoreRepositoryImpl @Inject constructor(
    private val datastoreLocalDataSource: DatastoreLocalDataSource,
) : DataStoreRepository {

    override fun getUserPrefs(): Flow<UserPreferences> = datastoreLocalDataSource.getUserPrefs()

    override suspend fun setUserIsSeenIntro(isSeen: Boolean) = datastoreLocalDataSource.setUserIsSeenIntro(isSeen)

    override suspend fun setUserIsLogin(isLogin: Boolean) = datastoreLocalDataSource.setUserIsLogin(isLogin)
}