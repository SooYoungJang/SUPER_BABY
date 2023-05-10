package com.sooyoungjang.superbaby.record

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sooyoungjang.component.RecordEmptyScreen
import com.sooyoungjang.component.SuperBabyCategoryRowContent
import com.sooyoungjang.component.SuperBabyLoading
import com.sooyoungjang.record.model.Record
import com.sooyoungjang.superbaby.R
import com.sooyoungjang.superbaby.record.contract.RecordState
import com.sooyoungjang.superbaby.record.contract.RecordUiState


@Composable
internal fun RecordRoute(
    modifier: Modifier = Modifier,
    viewModel: RecordViewModel = hiltViewModel(),
) {
    val state by viewModel.container.stateFlow.collectAsStateWithLifecycle()

    RecordScreen(
        onCategoryClick = viewModel::insertRecordSelection,
        state = state,
        modifier = modifier
    )
}

@Composable
internal fun RecordScreen(
    state: RecordState,
    onCategoryClick: (Record) -> Unit,
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        when (state.uiState) {
            RecordUiState.Loading -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    SuperBabyLoading(
                        modifier = modifier
                    )
                }
            }

            is RecordUiState.Success -> {
                SuperBabyCategoryRowContent(
                    categories = state.uiState.categories,
                    onCategoryClick = { id, startDateTime, endDateTime, category, memo ->
                        onCategoryClick.invoke(
                            Record(
                                id = id,
                                startDateTime = startDateTime,
                                endDateTime = endDateTime,
                                category = category,
                                memo = memo
                            )
                        )
                    }
                )
                RecordColumnContent(
                    userRecords = state.uiState.product,

                )
            }

            RecordUiState.Empty -> RecordEmptyScreen(stringResource(id = R.string.empty_header))
        }
    }
}
