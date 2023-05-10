package com.sooyoungjang.data.user.local

import com.sooyoungjang.data.user.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

interface UserLocalDataSource {
    suspend fun insertUserEntities(userEntities: List<UserEntity>)
    suspend fun insertUserEntity(userEntity: UserEntity)
//    fun getUserEntity(id: String): Flow<UserEntity>

}