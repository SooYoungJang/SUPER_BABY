package com.sooyoungjang.data.user

import com.sooyoungjang.data.user.entity.UserEntity
import com.sooyoungjang.data.user.entity.asExternalModel
import com.sooyoungjang.data.user.local.UserLocalDataSource
import com.sooyoungjang.data.user.remote.UserRemoteDataSource
import com.sooyoungjang.user.UserRepository
import com.sooyoungjang.user.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val localDataSource: UserLocalDataSource,
    private val remoteDataSource: UserRemoteDataSource
) : UserRepository {
    override suspend fun getUser(email: String): Flow<User?> = flow {
        emit(remoteDataSource.getUserEntity(email)?.asExternalModel())
    }

    override suspend fun insertUser(user: User) {
        val userEntity = UserEntity(email = user.email, userName = user.nickName, birth = user.birth)
        return localDataSource.insertUserEntity(userEntity)
    }

}