package com.sooyoungjang.datastore

import kotlinx.serialization.Serializable

@Serializable
data class UserPreferences(
    val isSeenIntro: Boolean,
    val isLogin: Boolean
)