package com.sooyoungjang.record.usecase

import com.sooyoungjang.record.RecordRepository
import com.sooyoungjang.record.model.Record
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllRecordUseCase @Inject constructor(
    private val recordRepository: RecordRepository
) {
    operator fun invoke(): Flow<List<Record>> {
        return recordRepository.getRecords()
    }

}