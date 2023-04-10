package com.sooyoungjang.superbaby.setting

import androidx.annotation.DrawableRes
import com.sooyoungjang.superbaby.navigation.bottom.SettingGraphConst
import com.sooyoungjang.ui.R

enum class SettingNavItem (
    val screenRoute: String,
    @DrawableRes
    val icon: Int,
    @DrawableRes
    val selectIcon: Int,
) {
    Setting(SettingGraphConst.Setting, R.drawable.icon_home, R.drawable.icon_home_select)
}