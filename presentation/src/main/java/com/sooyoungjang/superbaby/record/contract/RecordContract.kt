package com.sooyoungjang.superbaby.record.contract

import com.sooyoungjang.component.Category
import com.sooyoungjang.product.Product
import com.sooyoungjang.record.model.Record
import com.sooyoungjang.user.model.User

data class RecordState(
    val uiState: RecordUiState = RecordUiState.Loading
)

sealed interface RecordUiState {

    object Loading : RecordUiState

    object Empty: RecordUiState

    data class Success(
        val product: Product,
        val categories: List<Category>,
    ) : RecordUiState
}


sealed interface RecordSideEffect {

}

data class UserRecord constructor(
    val id: Int,
    val userName: String,
    val startDateTime: String,
    val endDateTime: String,
    val category: String,
    val memo: String?
) {
    constructor(record: Record, user: User) : this(
        id = record.id,
        userName = user.nickName,
        startDateTime = record.startDateTime,
        endDateTime = record.endDateTime,
        category = record.category,
        memo = record.memo
    )
}

fun List<Record>.mapToUserRecord(user: User): List<UserRecord> {
    return map { UserRecord(it, user) }
}

