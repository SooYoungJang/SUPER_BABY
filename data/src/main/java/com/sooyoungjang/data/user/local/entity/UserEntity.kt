package com.sooyoungjang.data.user.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sooyoungjang.user.model.User

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val userName: String
)

fun UserEntity.asExternalModel() = User(
    id = id.toString(),
    name = userName
)
