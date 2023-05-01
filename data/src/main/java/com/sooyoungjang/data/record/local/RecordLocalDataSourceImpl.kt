package com.sooyoungjang.data.record.local

import com.sooyoungjang.data.record.local.dao.RecordDao
import com.sooyoungjang.data.record.local.entity.RecordEntity
import kotlinx.coroutines.flow.Flow

class RecordLocalDataSourceImpl(
    private val recordDao: RecordDao
): RecordLocalDataSource {
    override suspend fun insertRecordEntities(recordEntities: List<RecordEntity>) {
        recordDao.insertAllRecordEntity(recordEntities)
    }

    override suspend fun insertRecordEntity(recordEntity: RecordEntity) {
        recordDao.insertRecordEntity(recordEntity)
    }

    override fun getRecordEntity(id: String): Flow<RecordEntity> {
        return recordDao.getRecordEntity(id)
    }

    override fun getAllRecordEntity(): Flow<List<RecordEntity>> {
        return recordDao.getAllRecordEntity()
    }

}