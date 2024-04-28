package com.example.medicineapp.login.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.medicineapp.R
import com.example.medicineapp.core.ui.components.AppHeader
import com.example.medicineapp.core.ui.components.CustomButton
import com.example.medicineapp.core.ui.components.CustomProgress
import com.example.medicineapp.core.ui.components.PasswordInput
import com.example.medicineapp.core.ui.components.TextError
import com.example.medicineapp.core.ui.components.TextInput
import com.example.medicineapp.core.ui.presentation.Screen
import com.example.medicineapp.login.data.model.Credentials
import com.example.medicineapp.login.presentation.viewmodel.LoginViewModel
import com.example.medicineapp.core.ui.theme.MedicineAppTheme
import com.example.medicineapp.core.ui.theme.colorWhite
import com.example.medicineapp.core.ui.theme.backgroundColor


@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel(),
) {


    val validation by viewModel.error.collectAsState(true)
    val loading by viewModel.isLoading.collectAsState(false)
    val userData by viewModel.userData.collectAsState(Credentials())


    LaunchedEffect(key1 = userData) {
        if (userData.isNotEmpty()) {
            viewModel.saveUser()
            navController.navigate(
                route = Screen.MedicineList.route
            )
        }
    }


    MedicineAppTheme() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .imePadding()
                .verticalScroll(rememberScrollState())
                .background(color = colorWhite)
                .padding(
                    bottom = 65.dp,
                ),

            ) {
            AppHeader(
                modifier = Modifier.background(color = backgroundColor),
                {},
                text = stringResource(id = R.string.signInText),
                false
            )

            Box(
                modifier = Modifier
                    .padding(
                        start = MedicineAppTheme.dimens.basicPaddingStart,
                        end = MedicineAppTheme.dimens.basicPaddingEnd
                    )
                    .weight(1f)
                    .padding(top = 50.dp)
            ) {

                Column(modifier = Modifier.fillMaxSize()) {
                    Box(
                        modifier = Modifier
                            .background(
                                backgroundColor,
                                shape = RoundedCornerShape(MedicineAppTheme.dimens.xSmallRoundedCorner)
                            )
                            .padding(MedicineAppTheme.dimens.basicPadding)
                    ) {
                        TextInput(
                            Modifier,
                            hintText = stringResource(id = R.string.username),
                            value = viewModel.credentials.username,
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                            onValueChange = { data ->
                                viewModel.credentials = viewModel.credentials.copy(username = data)
                            },
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))

                    Box(
                        modifier = Modifier
                            .background(
                                backgroundColor,
                                shape = RoundedCornerShape(MedicineAppTheme.dimens.xSmallRoundedCorner)
                            )
                            .padding(MedicineAppTheme.dimens.basicPadding)
                    ) {

                        PasswordInput(
                            Modifier,
                            hintText = stringResource(id = R.string.password),
                            value = viewModel.credentials.password,
                            onValueChange = { data ->
                                viewModel.credentials = viewModel.credentials.copy(password = data)
                            },
                        )

                    }

                    Box(modifier = Modifier.align(Alignment.End)) {
                        CustomButton(
                            Modifier.padding(top = MedicineAppTheme.dimens.basicPadding),
                            onContinueClicked = {
                                viewModel.login()
                            },
                            text = stringResource(id = R.string.signInText)
                        )
                        CustomProgress(
                            Modifier.padding(top = 20.dp, start = 30.dp),
                            isVisible = loading
                        )
                    }

                    if (!validation) {
                        TextError(text = stringResource(id = R.string.msgMissingRequiredFields))
                    }
                }

            }

        }


    }
}


@Preview
@Composable
fun SignInPasswordStepScreenPreview() {
    MedicineAppTheme() {
        Surface {
//            LoginScreen()
        }
    }
}