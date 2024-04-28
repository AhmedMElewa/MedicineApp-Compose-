package com.example.medicineapp.core.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

var MedicineAppDarkColorScheme = darkColorScheme(
    surface = colorSurface,
    onSurface = colorOnSurface,
    primary = colorPrimaryDark,
    onPrimary = colorPrimary,
    background = colorSurface,
    onBackground = colorOnSurface,
    error = colorRed,
    errorContainer = colorGray999,
)

var MedicineAppLightColorScheme = lightColorScheme(
    surface = colorSurface,
    onSurface = colorOnSurface,
    primary = colorPrimary,
    background = colorSurface,
    onBackground = colorOnSurface,
    error = colorRed,
    errorContainer = colorGray999
)

@Composable
fun MedicineAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme =
        if (darkTheme) MedicineAppDarkColorScheme else MedicineAppLightColorScheme
    val configuration = LocalConfiguration.current
    val dimensions = if (configuration.screenWidthDp <= 600) smallDimensions else sw600Dimensions

    ProvideDimens(dimensions = dimensions) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content,
        )
    }
}

@Composable
fun ProvideDimens(
    dimensions: Dimensions,
    content: @Composable () -> Unit
) {
    val dimensionSet = remember { dimensions }
    CompositionLocalProvider(LocalAppDimens provides dimensionSet, content = content)
}

private val LocalAppDimens = staticCompositionLocalOf {
    smallDimensions
}

object MedicineAppTheme {
    val dimens: Dimensions
        @Composable
        get() = LocalAppDimens.current
}