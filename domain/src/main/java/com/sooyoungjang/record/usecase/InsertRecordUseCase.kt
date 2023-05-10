package com.sooyoungjang.record.usecase

import com.sooyoungjang.record.RecordRepository
import com.sooyoungjang.record.model.Record
import javax.inject.Inject

class InsertRecordUseCase @Inject constructor(
    private val recordRepository: RecordRepository
) {
    suspend operator fun invoke(record: Record) {
        recordRepository.insertRecord(record)
    }
}