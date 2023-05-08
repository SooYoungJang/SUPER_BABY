package com.sooyoungjang.data.user

import android.util.Log
import com.sooyoungjang.data.user.local.UserLocalDataSource
import com.sooyoungjang.data.user.local.dao.UserDao
import com.sooyoungjang.data.user.local.entity.UserEntity
import com.sooyoungjang.data.user.local.entity.asExternalModel
import com.sooyoungjang.user.UserRepository
import com.sooyoungjang.user.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val localDataSource: UserLocalDataSource,
) : UserRepository {

    override fun getUser(id: String): Flow<User> {
        return localDataSource.getUserEntity(id).map { it.asExternalModel() }
    }

    override suspend fun insertUser(user: User) {
        val userEntity = UserEntity(id = user.id.toInt(), userName = user.name)
        return localDataSource.insertUserEntity(userEntity)
    }

}