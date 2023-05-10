package com.sooyoungjang.record.usecase

import com.sooyoungjang.record.RecordRepository
import com.sooyoungjang.record.model.Record
import com.sooyoungjang.user.UserRepository
import com.sooyoungjang.user.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filterNot
import javax.inject.Inject

class GetAllRecordUseCase @Inject constructor(
    private val recordRepository: RecordRepository
) {
    operator fun invoke(): Flow<List<Record>> {
        return recordRepository.getRecords()
    }

}