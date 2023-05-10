package com.sooyoungjang.data.user.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sooyoungjang.user.model.User

data class UserEntity(
    val email: String,
    val userName: String,
    val birth: String
)

fun UserEntity.asExternalModel() = User(
    email = email,
    nickName = userName,
    birth = birth
)
