package com.sooyoungjang.record.usecase

import com.sooyoungjang.product.Product
import com.sooyoungjang.record.RecordRepository
import com.sooyoungjang.user.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class GetProductUseCase @Inject constructor(
    private val recordRepository: RecordRepository,
    private val userRepository: UserRepository,
) {
    operator fun invoke(): Flow<Product> {
        val tempUserId = "0"

        return userRepository.getUser(tempUserId).combine(recordRepository.getRecords()) { user, records ->
            val recordsByDate = records.groupBy { it.startDateTime }
            Product(
                user = user,
                records = recordsByDate
            )
        }
    }

}