package com.example.medicineapp.medicine_list.presentation.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.medicineapp.R
import com.example.medicineapp.core.ui.components.AppHeader
import com.example.medicineapp.core.ui.components.TextError
import com.example.medicineapp.core.ui.presentation.Screen
import com.example.medicineapp.core.ui.theme.MedicineAppTheme
import com.example.medicineapp.core.ui.theme.backgroundColor
import com.example.medicineapp.core.ui.theme.colorWhite
import com.example.medicineapp.medicine_list.presentation.components.MedicineItem
import com.example.medicineapp.medicine_list.presentation.viewmodel.MedicineViewModel
import java.time.LocalTime

@Composable
fun MedicineList(
    navController: NavController,
    viewModel: MedicineViewModel,
) {


    viewModel.getLoggedInUser()
    viewModel.getMedicineList()


    val userName by viewModel.userName.collectAsState("")
    val medicineList by viewModel.medicineList.collectAsState(emptyList())
    val error by viewModel.error.collectAsState(Any())
    val errorMessage: String? = if (error is Int) {
        stringResource((error as Int))
    } else if (error is String) {
        error.toString()
    } else {
        null
    }

    val time = LocalTime.now()
    val greeting = when (time.hour) {
        in 0..11 -> stringResource(R.string.good_morning)
        in 12..17 -> stringResource(R.string.good_afternoon)
        else -> stringResource(R.string.good_evening)
    }

    MedicineAppTheme() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .imePadding()
                .background(color = colorWhite)
                .padding(
                    bottom = 65.dp,
                ),

            ) {
            AppHeader(
                modifier = Modifier.background(color = backgroundColor),
                {},
                text = "$greeting \n $userName",
                false
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                modifier = Modifier.padding(
                    start = MedicineAppTheme.dimens.basicPaddingStart,
                    end = MedicineAppTheme.dimens.basicPaddingEnd
                ),
                text = stringResource(R.string.your_medicine_list),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(8.dp))

            if (medicineList.isNullOrEmpty()) {
                errorMessage?.let {
                    TextError(text = it)
                }

            } else {
                LazyColumn(
                    Modifier
                        .fillMaxSize()
                        .padding(
                            start = MedicineAppTheme.dimens.basicPaddingStart,
                            end = MedicineAppTheme.dimens.basicPaddingEnd
                        ),
                    contentPadding = PaddingValues(bottom = 16.dp)
                ) {

                    items(medicineList.size) { i ->
                        MedicineItem(medicine = medicineList[i], onItemClick = {
                            viewModel.onMedicineSelect(it)
                            navController.navigate(
                                route = Screen.MedicineDetails.route
                            )
                        })
                    }
                }
            }

        }

    }
}