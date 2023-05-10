package com.sooyoungjang.product

import com.sooyoungjang.record.model.DateGroupRecord
import com.sooyoungjang.record.model.Record
import com.sooyoungjang.user.model.User

data class Product(
    val user: User,
    val records: Map<String, List<Record>>
)
