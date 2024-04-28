package com.example.medicineapp.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.medicineapp.core.ui.theme.MedicineAppTheme
import com.example.medicineapp.core.ui.theme.screenTitleTextStyle
import com.example.medicineapp.R
import com.example.medicineapp.core.ui.theme.backgroundColor
import com.example.medicineapp.core.ui.theme.signInErrorColor


@Composable
fun AppHeader(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    text: String,
    canBack: Boolean
) {
    Box(
        modifier = modifier
            .padding(top = MedicineAppTheme.dimens.basicPaddingTop, bottom = MedicineAppTheme.dimens.basicPadding)
            .fillMaxWidth()
    ) {
        if (canBack) {
            Image(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = null,
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(end = MedicineAppTheme.dimens.basicPadding)
                    .align(Alignment.CenterStart)
                    .clickable(
                        enabled = true,
                        onClick = onClick
                    ).padding(
                        start = MedicineAppTheme.dimens.basicPaddingStart,
                        end = MedicineAppTheme.dimens.basicPaddingEnd
                    ),
            )
        }
        Text(
            text = text,
            modifier = Modifier.align(Alignment.Center),
            style = screenTitleTextStyle
        )
    }

}

@Preview
@Composable
fun ButtonSignInEmailPreview() {
    MedicineAppTheme() {
        Surface {
            AppHeader(
                Modifier,
                { },
                "Sign In",
                true
            )
        }
    }
}