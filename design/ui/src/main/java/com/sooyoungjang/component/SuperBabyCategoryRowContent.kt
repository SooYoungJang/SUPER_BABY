package com.sooyoungjang.component

import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.sooyoungjang.ui.R

@Composable
fun SuperBabyCategoryRowContent(
    categories: List<Category>,
    onCategoryClick: (
        id: Int,
        startDateTime: String,
        endDateTime: String,
        category: String,
        memo: String?,
    ) -> Unit,
) {
    LazyRow() {
        categoryResourceCardItems(
            items = categories,
            onCategoryClick = onCategoryClick
        )
    }
}

fun LazyListScope.categoryResourceCardItems(
    items: List<Category>,
    onCategoryClick: (
        id: Int,
        startDateTime: String,
        endDateTime: String,
        category: String,
        memo: String?,
    ) -> Unit,
    itemModifier: Modifier = Modifier,
) = items(
    items = items,
    key = { it.ordinal },
    itemContent = { category ->
        val painter = painterResource(id = category.icon)
        val contentDescription = stringResource(id = category.description)
        val displayText = stringResource(id = category.displayText)

        SuperBabyCategoryCard(
            painter = painter,
            contentDescription = contentDescription,
            displayText = displayText,
            onCategoryClick = onCategoryClick,
            modifier = itemModifier,
        )
    },
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperBabyCategoryCard(
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

enum class Category(
    @StringRes val displayText: Int,
    @DrawableRes val icon: Int,
    @StringRes val description: Int,
) {
    BreastFeed(
        displayText = R.string.breast_feed,
        icon = R.drawable.icon_breastfeeding,
        description = R.string.breast_feed,
    ),

    Formula(
        displayText = R.string.formula,
        icon = R.drawable.icon_formula,
        description = R.string.formula
    ),

    BabyFood(
        displayText = R.string.baby_food,
        icon = R.drawable.icon_baby_food,
        description = R.string.baby_food,
    ),

    Diaper(
        displayText = R.string.diaper,
        icon = R.drawable.icon_diaper,
        description = R.string.diaper,
    ),

    Sleep(
        displayText = R.string.sleep,
        icon = R.drawable.icon_sleep,
        description = R.string.sleep,
    ),

    BreastPump(
        displayText = R.string.breast_pump,
        icon = R.drawable.icon_breast_pump,
        description = R.string.breast_pump
    ),

    Bath(
        displayText = R.string.bath,
        icon = R.drawable.icon_bath,
        description = R.string.bath
    ),

    Hospital(
        displayText = R.string.hospital,
        icon = R.drawable.icon_hospital,
        description = R.string.hospital
    ),

    Temperature(
        displayText = R.string.temperature,
        icon = R.drawable.icon_temperature,
        description = R.string.temperature
    ),

    Medication(
        displayText = R.string.medicine,
        icon = R.drawable.icon_medicine,
        description = R.string.medicine
    ),

    Snack(
        displayText = R.string.snack,
        icon = R.drawable.icon_snacks,
        description = R.string.snack
    ),

    Milk(
        displayText = R.string.milk,
        icon = R.drawable.icon_milk,
        description = R.string.milk
    ),

    Water(
        displayText = R.string.water,
        icon = R.drawable.icon_water,
        description = R.string.water
    ),

    Etc(
        displayText = R.string.etc,
        icon = R.drawable.icon_notebook,
        description = R.string.etc
    ),

    Setting(
        displayText = R.string.setting,
        icon = R.drawable.icon_settings,
        description = R.string.setting
    )

}