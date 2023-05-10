package com.sooyoungjang.di

import com.sooyoungjang.data.AppDatabase
import com.sooyoungjang.data.record.local.dao.RecordDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {

    @Provides
    fun providesRecordDao(
        database: AppDatabase,
    ): RecordDao = database.recordDao()
}
