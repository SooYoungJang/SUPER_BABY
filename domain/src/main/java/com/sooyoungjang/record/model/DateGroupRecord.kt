package com.sooyoungjang.record.model

data class DateGroupRecord(
    val startDate: String,
    val endDate: String,
    val records: List<Record>
)
