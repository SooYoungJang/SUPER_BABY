package com.sooyoungjang.data.user.remote

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.getValue
import com.sooyoungjang.data.user.entity.UserEntity
import com.sooyoungjang.di.Dispatcher
import com.sooyoungjang.di.SuperBabyDispatchers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject


class UserRemoteDataSourceImpl @Inject constructor(
    private val ref: DatabaseReference,
    @Dispatcher(SuperBabyDispatchers.IO)
    private val ioDispatcher: CoroutineDispatcher,
) : UserRemoteDataSource {

    override suspend fun getUserEntity(email: String): UserEntity = withContext(ioDispatcher) {
        ref.child("users").child("email").child(email).get().await().getValue<UserEntity>()
    }

}