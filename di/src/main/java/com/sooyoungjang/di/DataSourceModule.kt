package com.sooyoungjang.di

import com.sooyoungjang.data.datastore.local.DatastoreLocalDataSource
import com.sooyoungjang.data.datastore.local.DatastoreLocalDataSourceImpl
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
    fun bindsRecordLocalDataSource(impl: RecordLocalDataSourceImpl): RecordLocalDataSource

    @Singleton
    @Binds
    fun bindsUserLocalDataSource(impl: UserLocalDataSourceImpl): UserLocalDataSource

    @Singleton
    @Binds
    fun bindsDatastoreLocalDataSource(impl: DatastoreLocalDataSourceImpl): DatastoreLocalDataSource
}