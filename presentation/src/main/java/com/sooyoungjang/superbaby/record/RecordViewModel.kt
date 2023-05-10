package com.sooyoungjang.superbaby.record

import androidx.lifecycle.ViewModel
import com.sooyoungjang.record.model.Record
import com.sooyoungjang.record.usecase.InsertRecordUseCase
import com.sooyoungjang.superbaby.record.contract.RecordSideEffect
import com.sooyoungjang.superbaby.record.contract.RecordState
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class RecordViewModel @Inject constructor(
//    private val getProductUseCase: GetProductUseCase,
    private val insertRecordUseCase: InsertRecordUseCase
) : ViewModel(), ContainerHost<RecordState, RecordSideEffect> {

    override val container: Container<RecordState, RecordSideEffect> = container(
        initialState = RecordState()
    ) {
        prepareData()
    }

    fun insertRecordSelection(record: Record) = intent {
        insertRecordUseCase.invoke(record)
    }

    private fun prepareData() = intent {
//        getProductUseCase.invoke().collect {
//            reduce {
//                state.copy(
//                    uiState = RecordUiState.Success(
//                        product = it,
//                        categories = Category.values().toList()
//                    )
//                )
//            }
//        }


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