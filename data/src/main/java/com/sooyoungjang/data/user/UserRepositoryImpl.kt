package com.sooyoungjang.data.user

import com.sooyoungjang.data.user.local.UserLocalDataSource
import com.sooyoungjang.data.user.local.entity.UserEntity
import com.sooyoungjang.data.user.local.entity.asExternalModel
import com.sooyoungjang.user.UserRepository
import com.sooyoungjang.user.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val localDataSource: UserLocalDataSource,
) : UserRepository {

//    override fuø

    override suspend fun insertUser(user: User) {
        val userEntity = UserEntity(email = user.email, userName = user.nickName, birth = user.birth)
        return localDataSource.insertUserEntity(userEntity)
    }

}