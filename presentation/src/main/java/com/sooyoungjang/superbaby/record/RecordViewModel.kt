package com.sooyoungjang.superbaby.record

import androidx.lifecycle.ViewModel
import com.sooyoungjang.record.usecase.GetAllRecordUseCase
import com.sooyoungjang.record.usecase.InsertRecordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecordViewModel @Inject constructor(
    private val getAllRecordUseCase: GetAllRecordUseCase,
    private val insertRecordUseCase: InsertRecordUseCase
) : ViewModel() {

}