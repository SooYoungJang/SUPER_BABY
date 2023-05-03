package com.sooyoungjang.superbaby.record

import android.util.Log
import androidx.lifecycle.ViewModel
import com.sooyoungjang.component.Category
import com.sooyoungjang.record.usecase.GetAllRecordUseCase
import com.sooyoungjang.record.usecase.GetUserUseCase
import com.sooyoungjang.record.usecase.InsertRecordUseCase
import com.sooyoungjang.superbaby.record.contract.RecordSideEffect
import com.sooyoungjang.superbaby.record.contract.RecordState
import com.sooyoungjang.superbaby.record.contract.RecordUiState
import com.sooyoungjang.superbaby.record.contract.UserRecord
import com.sooyoungjang.superbaby.record.contract.mapToUserRecord
import com.sooyoungjang.user.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.combine
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class RecordViewModel @Inject constructor(
    private val getAllRecordUseCase: GetAllRecordUseCase,
    private val getUserUseCase: GetUserUseCase,
    private val insertRecordUseCase: InsertRecordUseCase,
) : ViewModel(), ContainerHost<RecordState, RecordSideEffect> {

    override val container: Container<RecordState, RecordSideEffect> = container(
        initialState = RecordState()
    ) {
        prepareData()
    }

    fun insertRecordSelection() = intent {
//        insertRecordUseCase.invoke()
    }

    private fun prepareData() = intent {
        getAllRecordUseCase.invoke().collect {
            Log.d("test","eddy test ㅁㅁㅁㅁ ${it.size}")
            reduce {
                state.copy(
                    uiState = RecordUiState.Success(
                        userRecords = it.map { UserRecord(it, User(id = "0" , name = "eddy")) },
                        categories = Category.values().toList()
                    )
                )
            }
        }
//        getAllRecordUseCase.invoke().combine(getUserUseCase.invoke()) { records, user -> records.mapToUserRecord(user) }
//            .collect {
//                reduce {
//                    state.copy(
//                        uiState = RecordUiState.Success(
//                            userRecords = it,
//                            categories = Category.values().toList()
//                        )
//                    )
//                }
//            }
    }
}