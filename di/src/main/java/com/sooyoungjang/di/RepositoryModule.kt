package com.sooyoungjang.di

import com.sooyoungjang.data.datastore.DataStoreRepositoryImpl
import com.sooyoungjang.data.record.RecordRepositoryImpl
import com.sooyoungjang.data.user.UserRepositoryImpl
import com.sooyoungjang.datastore.DataStoreRepository
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
    fun bindsRecordRepository(impl: RecordRepositoryImpl): RecordRepository

    @Singleton
    @Binds
    fun bindsUserRepository(impl: UserRepositoryImpl): UserRepository


    @Singleton
    @Binds
    fun bindsUserPrefsRepository(impl: DataStoreRepositoryImpl): DataStoreRepository
}