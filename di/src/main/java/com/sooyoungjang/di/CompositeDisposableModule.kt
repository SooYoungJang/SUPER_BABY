package com.sooyoungjang.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.disposables.CompositeDisposable

@Module
@InstallIn(SingletonComponent::class)
object CompositeDisposableModule {

    @Provides
    fun compositeDisposable(): CompositeDisposable = CompositeDisposable()

}