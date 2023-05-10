package com.sooyoungjang.record.usecase

import com.sooyoungjang.datastore.DataStoreRepository
import javax.inject.Inject

class SetUserIntroSeenUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) {
    suspend operator fun invoke(isSeen: Boolean) = dataStoreRepository.setUserIsSeenIntro(isSeen)
}