package com.sooyoungjang.record.usecase

import com.sooyoungjang.user.UserRepository
import com.sooyoungjang.user.model.User
import javax.inject.Inject

class InsertUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(user: User) {
        userRepository.insertUser(user)
    }
}