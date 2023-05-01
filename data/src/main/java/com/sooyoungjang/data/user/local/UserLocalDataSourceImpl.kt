package com.sooyoungjang.data.user.local

import com.sooyoungjang.data.user.local.dao.UserDao
import com.sooyoungjang.data.user.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

class UserLocalDataSourceImpl(
    private val userDao: UserDao
): UserLocalDataSource {

    override suspend fun insertUserEntities(userEntities: List<UserEntity>) {
        userDao.insertAllUserEntity(userEntities)
    }

    override suspend fun insertUserEntity(userEntity: UserEntity) {
        userDao.insertUserEntity(userEntity)
    }

    override fun getUserEntity(id: String): Flow<UserEntity> {
        return userDao.getUserEntity(id)
    }
}