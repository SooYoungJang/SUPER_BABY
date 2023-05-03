package com.sooyoungjang.record.usecase

import com.sooyoungjang.user.UserRepository
import com.sooyoungjang.user.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke(): Flow<User> {
        val tempUserId = "0"
        return userRepository.getUser(tempUserId)
    }

}