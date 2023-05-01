package com.sooyoungjang.data.di

import com.sooyoungjang.data.record.RecordRepositoryImpl
import com.sooyoungjang.data.user.UserRepositoryImpl
import com.sooyoungjang.record.RecordRepository
import com.sooyoungjang.user.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsRecordRepository(
        recordRepository: RecordRepositoryImpl
    ): RecordRepository

    @Binds
    fun bindsUserRepository(
        userRepository: UserRepositoryImpl
    ): UserRepository

}