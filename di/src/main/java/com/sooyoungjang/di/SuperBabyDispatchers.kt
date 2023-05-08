package com.sooyoungjang.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val superBabyDispatcher: SuperBabyDispatchers)

enum class SuperBabyDispatchers {
    IO,
}
