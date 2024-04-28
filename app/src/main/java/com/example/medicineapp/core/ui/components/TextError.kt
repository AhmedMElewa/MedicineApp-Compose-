package com.example.medicineapp.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.medicineapp.R
import com.example.medicineapp.core.ui.theme.MedicineAppTheme
import com.example.medicineapp.core.ui.theme.errorTextStyle
import com.example.medicineapp.core.ui.theme.signInErrorColor

@Composable
fun TextError(
    modifier: Modifier = Modifier,
    text: String
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(MedicineAppTheme.dimens.errorMessageHeight)
            .padding(
                top = MedicineAppTheme.dimens.mgTopErrorTxtSignIn,
                start = MedicineAppTheme.dimens.paddingHorizontalErrorTxtSignIn,
                end = MedicineAppTheme.dimens.paddingHorizontalErrorTxtSignIn,
            )
            .background(color = signInErrorColor, shape = RoundedCornerShape(MedicineAppTheme.dimens.xxSmallRoundedCorner))
    ) {
        Text(
            text = text,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = MedicineAppTheme.dimens.errorTextPadding, bottom = MedicineAppTheme.dimens.errorTextPadding),
            style = errorTextStyle
        )
    }

}

@Preview
@Composable
fun TextErrorPreview() {
    MedicineAppTheme() {
        Surface {
            TextError(
                Modifier,
                stringResource(
                    id = R.string.msgMissingRequiredFields
                ),
            )
        }
    }
}