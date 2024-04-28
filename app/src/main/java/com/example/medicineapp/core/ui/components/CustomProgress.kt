package com.example.medicineapp.core.ui.components

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.medicineapp.core.ui.theme.MedicineAppTheme
import com.example.medicineapp.core.ui.theme.colorWhite

@Composable
fun CustomProgress(
    modifier: Modifier = Modifier,
    isVisible: Boolean
) {
    if (isVisible) {
        CircularProgressIndicator(
            modifier = modifier
                .widthIn(MedicineAppTheme.dimens.progressSignIn)
                .heightIn(MedicineAppTheme.dimens.progressSignIn),
            color = colorWhite
        )
    }
}

@Preview
@Composable
fun SignInProgressPreview() {
    MedicineAppTheme() {
        Surface {
            CustomProgress(
                Modifier,
                true
            )
        }
    }
}