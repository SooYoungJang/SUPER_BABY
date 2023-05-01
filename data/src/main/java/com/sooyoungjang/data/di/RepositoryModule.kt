package com.sooyoungjang.data.di

import com.sooyoungjang.data.record.RecordRepositoryImpl
import com.sooyoungjang.data.record.local.RecordLocalDataSource
import com.sooyoungjang.data.user.UserRepositoryImpl
import com.sooyoungjang.data.user.local.UserLocalDataSource
import com.sooyoungjang.record.RecordRepository
import com.sooyoungjang.user.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun recordRepository(local: RecordLocalDataSource): RecordRepository {
        return RecordRepositoryImpl(local)
    }

    @Singleton
    @Provides
    fun userRepository(local: UserLocalDataSource): UserRepository {
        return UserRepositoryImpl(local)
    }

}