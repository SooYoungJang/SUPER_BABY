package com.sooyoungjang.superbaby.main.ui

import androidx.annotation.DrawableRes
import com.sooyoungjang.ui.R

enum class TopLevelDestination(
    val text: String,
    val screenRoute: String,
    @DrawableRes
    val icon: Int,
    @DrawableRes
    val selectIcon: Int,
) {
    Record(BottomGraphConst.RecordTitle, BottomGraphConst.Record, R.drawable.icon_home, R.drawable.icon_home_select),
    TimeLine(BottomGraphConst.TimeLineTitle, BottomGraphConst.TimeLine, R.drawable.icontime_line, R.drawable.icon_time_line_select),
    ChatGpt(BottomGraphConst.ChatGptTitle, BottomGraphConst.ChatGpt, R.drawable.icon_bot, R.drawable.icon_bot_select),
    Integral(BottomGraphConst.IntegralTitle, BottomGraphConst.Integral, R.drawable.icon_integral, R.drawable.icon_integral_select)
}

object BottomGraphConst {
    const val Record = "Record"
    const val RecordTitle = "기록"
    const val TimeLine = "TimeLine"
    const val TimeLineTitle = "타임라인"
    const val Integral = "Integral"
    const val IntegralTitle = "전체"
    const val ChatGpt = "ChatGpt"
    const val ChatGptTitle = "ChatGpt"
}
