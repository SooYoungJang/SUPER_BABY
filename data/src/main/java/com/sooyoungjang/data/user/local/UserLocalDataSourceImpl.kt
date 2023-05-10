package com.sooyoungjang.data.user.local

import com.sooyoungjang.data.user.entity.UserEntity
import javax.inject.Inject

class UserLocalDataSourceImpl @Inject constructor(
): UserLocalDataSource {

    override suspend fun insertUserEntities(userEntities: List<UserEntity>) {
    }

    override suspend fun insertUserEntity(userEntity: UserEntity) {
    }

}