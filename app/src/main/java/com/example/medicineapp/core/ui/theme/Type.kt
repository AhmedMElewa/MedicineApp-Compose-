package com.example.medicineapp.core.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

var screenTitleTextStyle = TextStyle(
    fontSize = 18.sp,
    color = colorScreenTitle,
    textAlign = TextAlign.Center,
    fontFamily = FontFamily.Default,
)

val hintTextStyle = TextStyle(
    fontSize = 15.sp,
    color = colorGray999,
    fontFamily =  FontFamily.Default,
)

val editTextNormal = TextStyle(
    fontSize = 15.sp,
    color = appTextColor,
    fontFamily =  FontFamily.Default,
)

val errorTextStyle = TextStyle(
    fontSize = 15.sp,
    color = colorRed,
    fontFamily =  FontFamily.Default,
    textAlign = TextAlign.Center,
)