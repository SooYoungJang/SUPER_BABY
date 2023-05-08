package com.sooyoungjang.datastore

import kotlinx.serialization.Serializable

@Serializable
data class UserPreferences(
    val isSeenTutorial: Boolean,
    val isLogin: Boolean
)