package com.sooyoungjang.data.record.local

import com.sooyoungjang.data.record.local.entity.RecordEntity
import kotlinx.coroutines.flow.Flow

interface RecordLocalDataSource {
    suspend fun insertRecordEntities(recordEntities: List<RecordEntity>)
    suspend fun insertRecordEntity(recordEntity: RecordEntity)
    fun getRecordEntity(id: String): Flow<RecordEntity>
    fun getAllRecordEntity(): Flow<List<RecordEntity>>

}