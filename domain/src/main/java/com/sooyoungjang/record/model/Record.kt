package com.sooyoungjang.record.model

data class Record(
    val id: Int,
    val startDateTime: String,
    val endDateTime: String,
    val category: String,
    val memo: String?
)