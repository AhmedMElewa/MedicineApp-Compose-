package com.example.medicineapp.core.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.medicineapp.core.ui.theme.MedicineAppTheme
import com.example.medicineapp.core.ui.theme.colorBlack
import com.example.medicineapp.core.ui.theme.colorGray999
import com.example.medicineapp.core.ui.theme.colorWhite
import com.example.medicineapp.core.ui.theme.editTextNormal
import com.example.medicineapp.core.ui.theme.hintTextStyle
import com.example.medicineapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInput(
    modifier: Modifier = Modifier,
    hintText: String,
    value: String,
    onValueChange: (String) -> Unit,
    singleLine: Boolean = true,
    height: Dp = 50.dp,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    leadingIcon: @Composable (() -> Unit)? = null,
    indicatorColor: Color = Color.Transparent
) {
    TextField(
        modifier = modifier.fillMaxWidth().heightIn(height),
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(text = hintText, style = hintTextStyle)
        },
        keyboardOptions = keyboardOptions,
        colors = TextFieldDefaults.textFieldColors(
            textColor = colorBlack,
            disabledTextColor = colorBlack,
            focusedIndicatorColor = indicatorColor,
            unfocusedIndicatorColor = indicatorColor,
            disabledIndicatorColor = indicatorColor,
            placeholderColor = indicatorColor,
            cursorColor = colorBlack,
            focusedLabelColor = colorBlack,
            containerColor = colorWhite
        ),
        singleLine = singleLine,
        textStyle = editTextNormal,
        leadingIcon = leadingIcon,

    )
}

@Preview
@Composable
fun TextInputPreview() {
    MedicineAppTheme {
        var userName by remember { mutableStateOf("") }
        Surface {
            TextInput(
                Modifier,
                stringResource(
                    id = R.string.app_name
                ),
                value = userName,
                onValueChange = { userName = it },
                indicatorColor = colorGray999
            )
        }
    }
}
