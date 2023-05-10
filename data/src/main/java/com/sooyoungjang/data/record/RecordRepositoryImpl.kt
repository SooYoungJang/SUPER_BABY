package com.sooyoungjang.data.record

import com.sooyoungjang.data.record.local.RecordLocalDataSource
import com.sooyoungjang.data.record.local.entity.RecordEntity
import com.sooyoungjang.data.record.local.entity.asExternalModel
import com.sooyoungjang.record.RecordRepository
import com.sooyoungjang.record.model.Record
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RecordRepositoryImpl @Inject constructor(
    private val local: RecordLocalDataSource,
) : RecordRepository {

    override fun getRecords(): Flow<List<Record>> {
        return local.getAllRecordEntity().map { it.map(RecordEntity::asExternalModel) }
    }

    override fun getRecord(id: String): Flow<Record> {
        return local.getRecordEntity(id).map { it.asExternalModel() }
    }

    override suspend fun insertRecord(record: Record) {
        val entity = RecordEntity(
            id = record.id,
            startDateTime = record.startDateTime,
            endDateTime = record.endDateTime,
            category = record.category,
            memo = record.memo
        )

        local.insertRecordEntity(entity)
    }
}