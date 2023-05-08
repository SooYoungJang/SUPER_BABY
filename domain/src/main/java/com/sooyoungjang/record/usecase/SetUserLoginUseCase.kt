package com.sooyoungjang.record.usecase

import com.sooyoungjang.datastore.DataStoreRepository
import javax.inject.Inject

class SetUserLoginUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) {
    suspend operator fun invoke(isLogin: Boolean) {
        dataStoreRepository.setUserIsLogin(isLogin)
    }

}