package com.example.medicineapp.core.ui.components

import com.example.medicineapp.R
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medicineapp.core.ui.theme.MedicineAppTheme
import com.example.medicineapp.core.ui.theme.colorSurface
import com.example.medicineapp.core.ui.theme.editTextNormal

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    onContinueClicked: () -> Unit,
    text: String

) {
    Box() {
        Button(
            modifier = modifier
                .heightIn(MedicineAppTheme .dimens.heightButtonSignIn),
            contentPadding = PaddingValues(
                start = 20.dp,
                end = 20.dp,
            ),
            onClick = onContinueClicked,
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
            shape = RoundedCornerShape(MedicineAppTheme.dimens.smallRoundedCorner)
        ) {
            Text(
                text,
                style = editTextNormal,
                color = colorSurface,
                fontFamily = FontFamily.Default,
                fontSize = MedicineAppTheme.dimens.materialTextBody2
            )
        }
    }

}


@Preview
@Composable
fun SignInButtonPreview() {
    MedicineAppTheme() {
        Surface {
            CustomButton(
                Modifier,
                {},
                stringResource(id = R.string.signInText),
            )
        }
    }
}