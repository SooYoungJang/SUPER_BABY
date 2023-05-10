package com.sooyoungjang.data.user.remote

import com.sooyoungjang.data.user.entity.UserEntity
import kotlinx.coroutines.flow.Flow

interface UserRemoteDataSource {
    suspend fun getUserEntity(email: String): Flow<UserEntity>
}