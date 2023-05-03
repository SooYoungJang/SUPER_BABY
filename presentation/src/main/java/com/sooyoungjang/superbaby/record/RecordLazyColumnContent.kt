//package com.sooyoungjang.superbaby.record
//
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.WindowInsets
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.safeDrawing
//import androidx.compose.foundation.layout.windowInsetsBottomHeight
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.testTag
//import androidx.compose.ui.unit.dp
//import com.sooyoungjang.superbaby.record.contract.UserRecord
//
//@Composable
//fun RecordLazyColumnContent(
//    records: List<UserRecord>,
//    onCategoryClick: () -> Unit,
//    modifier: Modifier = Modifier,
//) {
//    LazyColumn(
//        modifier = modifier
//            .padding(horizontal = 24.dp)
//            .testTag("interests:topics"),
//        contentPadding = PaddingValues(vertical = 16.dp),
//    ) {
//        records.forEach { record ->
//            val recordId = record.id
//            item(key = recordId) {
//                InterestsItem(
//                    name = followableTopic.topic.name,
//                    following = followableTopic.isFollowed,
//                    description = followableTopic.topic.shortDescription,
//                    topicImageUrl = followableTopic.topic.imageUrl,
//                    onClick = { onCategoryClick(topicId) },
//                    onFollowButtonClick = { onFollowButtonClick(topicId, it) },
//                )
//            }
//        }
//
//        item {
//            Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.safeDrawing))
//        }
//    }
//}