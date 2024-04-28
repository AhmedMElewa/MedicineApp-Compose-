package com.example.medicineapp.core.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.medicineapp.R
import com.example.medicineapp.core.ui.theme.MedicineAppTheme
import com.example.medicineapp.core.ui.theme.colorBlack
import com.example.medicineapp.core.ui.theme.colorGray999
import com.example.medicineapp.core.ui.theme.colorWhite
import com.example.medicineapp.core.ui.theme.editTextNormal


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInput(
    modifier: Modifier = Modifier,
    hintText: String,
    value: String,
    onValueChange: (String) -> Unit,
    indicatorColor: Color = colorWhite
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    TextField(
        value = value,
        onValueChange = onValueChange,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        singleLine = true,
        modifier = modifier.fillMaxWidth(),
        placeholder = { Text(text = hintText, style = TextStyle(color = colorGray999)) },
        trailingIcon = {
            val drawableResource =
                if (passwordVisible) R.drawable.ic_password_enabled
                else R.drawable.ic_password_disabled


            // Please provide localized description for accessibility services
            val description = if (passwordVisible) "Hide password" else "Show password"

            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(painter = painterResource(id = drawableResource), description)
            }
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Default,
            keyboardType = KeyboardType.Password
        ),
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colorScheme.onBackground,
            disabledTextColor = MaterialTheme.colorScheme.onBackground,
            focusedIndicatorColor = indicatorColor,
            unfocusedIndicatorColor = indicatorColor,
            disabledIndicatorColor = indicatorColor,
            placeholderColor = indicatorColor,
            cursorColor = colorBlack,
            focusedLabelColor = colorBlack,
            containerColor = colorWhite


        ),
        textStyle = editTextNormal
    )
}


@Preview
@Composable
fun PasswordInputPreview() {
    MedicineAppTheme() {
        var value by remember { mutableStateOf("") }

        Surface {
            PasswordInput(
                Modifier,
                stringResource(id = R.string.password),
                value = value,
                onValueChange = { value = it },

            )
        }
    }
}