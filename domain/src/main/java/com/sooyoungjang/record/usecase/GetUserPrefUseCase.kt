package com.sooyoungjang.record.usecase

import com.sooyoungjang.datastore.DataStoreRepository
import com.sooyoungjang.datastore.UserPreferences
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserPrefUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) {
    suspend operator fun invoke(): Flow<UserPreferences> = dataStoreRepository.getUserPrefs()
}