package com.sooyoungjang.record.usecase

import com.sooyoungjang.datastore.DataStoreRepository
import javax.inject.Inject

class SetUserTutorialSeenUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) {
    suspend operator fun invoke(isSeen: Boolean) = dataStoreRepository.setUserIsSeenTutorial(isSeen)
}