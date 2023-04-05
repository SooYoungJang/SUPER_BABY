package com.sooyoungjang.superbaby.navigation

import androidx.annotation.DrawableRes
import com.sooyoungjang.ui.R

enum class BottomNavItem(
    val screenRoute: String,
    @DrawableRes
    val icon: Int,
    @DrawableRes
    val selectIcon: Int,
) {
    Home(Const.Home, R.drawable.icon_home, R.drawable.icon_home_select),
    ChatGpt(Const.ChatGpt, R.drawable.icon_bot, R.drawable.icon_bot_select),
    Integral(Const.Integral, R.drawable.icon_integral, R.drawable.icon_integral_select)
}