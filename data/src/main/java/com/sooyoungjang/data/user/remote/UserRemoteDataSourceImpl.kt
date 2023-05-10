package com.sooyoungjang.data.user.remote

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.getValue
import com.sooyoungjang.data.user.entity.UserEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class UserRemoteDataSourceImpl(
    private val cartRef: DatabaseReference,
) : UserRemoteDataSource {

    var mRootRef = FirebaseDatabase.getInstance().reference
    var conditionRef: DatabaseReference = mRootRef.child("User")

    override suspend fun getUserEntity(email: String): Flow<UserEntity> = flow {

        cartRef.child("users").child("email").child(email).get().addOnSuccessListener {
            it.getValue<UserEntity>()
        }.addOnFailureListener {

        }

    }

}