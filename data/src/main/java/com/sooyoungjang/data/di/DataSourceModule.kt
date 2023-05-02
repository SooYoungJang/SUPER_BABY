package com.sooyoungjang.data.di

import com.sooyoungjang.data.record.local.RecordLocalDataSource
import com.sooyoungjang.data.record.local.RecordLocalDataSourceImpl
import com.sooyoungjang.data.user.local.UserLocalDataSource
import com.sooyoungjang.data.user.local.UserLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Singleton
    @Binds
    fun bindsRecordLocalDataSource(recordDao: RecordLocalDataSourceImpl): RecordLocalDataSource

    @Singleton
    @Binds
    fun bindsUserLocalDataSource(userDao: UserLocalDataSourceImpl): UserLocalDataSource
}