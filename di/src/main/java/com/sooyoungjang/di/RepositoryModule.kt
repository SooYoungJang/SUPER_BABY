package com.sooyoungjang.di

import com.sooyoungjang.data.record.RecordRepositoryImpl
import com.sooyoungjang.data.user.UserRepositoryImpl
import com.sooyoungjang.record.RecordRepository
import com.sooyoungjang.user.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Singleton
    @Binds
    fun bindsRecordRepository(local: RecordRepositoryImpl): RecordRepository

    @Singleton
    @Binds
    fun bindsUserRepository(local: UserRepositoryImpl): UserRepository


}