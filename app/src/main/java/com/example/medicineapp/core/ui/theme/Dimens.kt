package com.example.medicineapp.core.ui.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Dimensions(
    val basicPadding: Dp = 15.dp,
    val basicPaddingTop: Dp = 28.dp,
    val progressSignIn: Dp = 40.dp,
    val heightButtonSignIn: Dp = 38.dp,
    val smallRoundedCorner:Dp = 5.dp,
    val xSmallRoundedCorner:Dp = 4.dp,
    val xxSmallRoundedCorner:Dp = 2.5.dp,
    val materialTextBody2: TextUnit = 13.sp,
    val mgTopErrorTxtSignIn: Dp = 15.dp,
    val errorMessageHeight: Dp = 33.dp,
    val errorTextPadding: Dp = 7.5.dp,
    val paddingHorizontalErrorTxtSignIn: Dp = 5.dp,
    val basicPaddingStart: Dp,
    val basicPaddingEnd: Dp,
    val basicPaddingBottom: Dp,
)

val smallDimensions = Dimensions(
    basicPaddingStart = 15.dp,
    basicPaddingEnd = 15.dp,
    basicPaddingBottom = 65.dp,
)

val sw600Dimensions = Dimensions(
    basicPaddingStart = 30.dp,
    basicPaddingEnd = 30.dp,
    basicPaddingBottom = 60.dp,
)



