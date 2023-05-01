package com.sooyoungjang.record

import com.sooyoungjang.record.model.Record
import kotlinx.coroutines.flow.Flow

interface RecordRepository {
    fun getRecords(): Flow<List<Record>>
    fun getRecord(id: String): Flow<Record>
    suspend fun insertRecord(record: Record)
}