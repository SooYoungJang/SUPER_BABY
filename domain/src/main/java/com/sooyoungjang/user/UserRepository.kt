package com.sooyoungjang.user

import com.sooyoungjang.user.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUser(email: String): Flow<User>
    suspend fun insertUser(user: User)
}