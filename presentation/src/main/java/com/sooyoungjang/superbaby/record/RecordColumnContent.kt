package com.sooyoungjang.superbaby.record

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.sooyoungjang.product.Product
import com.sooyoungjang.record.model.Record

@Composable
fun RecordColumnContent(
    userRecords: Product,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .padding(horizontal = 24.dp)
            .testTag("interests:topics"),
        contentPadding = PaddingValues(vertical = 16.dp),
    ) {

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserRecordCard(
    painter: Painter,
    contentDescription: String,
    displayText: String,
    onCategoryClick: (
        id: Int,
        startDateTime: String,
        endDateTime: String,
        category: String,
        memo: String?,
    ) -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        onClick = { onCategoryClick.invoke(0, "2023-05-03", "2023-05-03", contentDescription, null) },
        shape = RoundedCornerShape(8.dp),
        modifier = modifier.padding(3.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(painter = painter, contentDescription = contentDescription)
            Spacer(modifier = modifier.padding(top = 3.dp))
            Text(text = displayText)
        }
    }
}