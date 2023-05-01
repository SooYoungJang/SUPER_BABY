package com.sooyoungjang.data.record.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sooyoungjang.record.model.Record


@Entity(tableName = "records")
class RecordEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val startDateTime: String,
    val endDateTime: String,
    val category: String,
    val memo: String
)

fun RecordEntity.asExternalModel() = Record(
    id = id,
    startDateTime = startDateTime,
    endDateTime = endDateTime,
    category = category,
    memo = memo,
)
