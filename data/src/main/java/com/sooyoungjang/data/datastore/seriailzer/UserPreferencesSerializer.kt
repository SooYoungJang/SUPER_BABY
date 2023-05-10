package com.sooyoungjang.data.datastore.seriailzer

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.sooyoungjang.datastore.UserPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Inject

class UserPreferencesSerializer @Inject constructor() : Serializer<UserPreferences> {
    override val defaultValue: UserPreferences = UserPreferences(isSeenIntro = false, isLogin = false)

    override suspend fun readFrom(input: InputStream): UserPreferences {
        try {
            return Json.decodeFromString(
                UserPreferences.serializer(), input.readBytes().decodeToString()
            )
        } catch (e: SerializationException) {
            throw CorruptionException("Unable to read UserPrefs", e)
        }
    }

    override suspend fun writeTo(t: UserPreferences, output: OutputStream) {
        withContext(Dispatchers.IO) {
            output.write(
                Json.encodeToString(UserPreferences.serializer(), t).encodeToByteArray()
            )
        }
    }
}