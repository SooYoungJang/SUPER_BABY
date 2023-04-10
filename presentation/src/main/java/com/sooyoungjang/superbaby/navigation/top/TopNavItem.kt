package com.sooyoungjang.superbaby.navigation.top

import com.sooyoungjang.superbaby.navigation.bottom.BottomGraphConst

enum class TopNavItem(
    val text: String,
    val screenRoute: String
) {
    Date(BottomGraphConst.RecordTitle, BottomGraphConst.Record)
}