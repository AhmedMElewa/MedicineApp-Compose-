package com.example.medicineapp.medicine_details.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.medicineapp.R
import com.example.medicineapp.core.ui.components.AppHeader
import com.example.medicineapp.core.ui.theme.MedicineAppTheme
import com.example.medicineapp.core.ui.theme.backgroundColor
import com.example.medicineapp.core.ui.theme.colorWhite
import com.example.medicineapp.medicine_list.presentation.viewmodel.MedicineViewModel

@Composable
fun MedicineDetails(navController: NavController, viewModel: MedicineViewModel) {

    val medicine by viewModel.selectedMedicine.collectAsState(null)

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
                {navController.popBackStack()},
                text = stringResource(R.string.medicine_details),
                true
            )

            Spacer(modifier = Modifier.height(8.dp))

            medicine?.let {
                Column(modifier = Modifier
                    .padding(vertical = 16.dp, horizontal = 16.dp)
                    .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = stringResource(R.string.name, medicine?.name?:""),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = stringResource(R.string.dose, medicine?.dose?:"") ,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = stringResource(R.string.strength, medicine?.strength?:""),
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }?: run {
                Text(
                    text = stringResource(R.string.medicine_not_found),
                )
            }
        }


    }
}