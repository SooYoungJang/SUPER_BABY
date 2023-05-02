package com.sooyoungjang.data.di

import com.sooyoungjang.data.AppDatabase
import com.sooyoungjang.data.record.local.dao.RecordDao
import com.sooyoungjang.data.user.local.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {
    @Provides
    fun providesUserDao(
        database: AppDatabase,
    ): UserDao = database.userDao()

    @Provides
    fun providesRecordDao(
        database: AppDatabase,
    ): RecordDao = database.recordDao()
}
