package com.sooyoungjang.di

import android.content.Context
import androidx.room.Room
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.sooyoungjang.data.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun providesAppDatabase(
        @ApplicationContext context: Context,
    ): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "super-baby-database",
    ).build()

    @Singleton
    @Provides
    fun provideDatabaseReference(): DatabaseReference {
        return FirebaseDatabase.getInstance().reference
    }

}