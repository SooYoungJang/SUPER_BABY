package com.sooyoungjang.data.record.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sooyoungjang.data.record.local.entity.RecordEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllRecordEntity(recordEntities: List<RecordEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecordEntity(recordEntity: RecordEntity)

    @Query("SELECT * FROM records")
    fun getAllRecordEntity(): Flow<List<RecordEntity>>

    @Query(
        value = """
        SELECT * FROM records
        WHERE id = :id
    """,
    )
    fun getRecordEntity(id: String): Flow<RecordEntity>

    @Query("DELETE FROM records")
    suspend fun deleteAllRecordEntity()


}