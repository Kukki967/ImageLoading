package com.quantic.mob.app.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.kukki.imageloading.ui.theme.Firefly


val TitleAppBar by lazy {
    TextStyle(
        fontWeight = FontWeight.W500,
        fontSize = 16.sp,
        textAlign = TextAlign.Center,
        color = Firefly
    )
}

val BrandingIcon by lazy {
    TextStyle(
        fontWeight = FontWeight.W600,
        fontSize = 46.sp,
        color = Firefly
    )
}
