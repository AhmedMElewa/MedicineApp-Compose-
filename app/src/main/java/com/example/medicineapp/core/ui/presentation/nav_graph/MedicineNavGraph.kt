package com.example.medicineapp.core.ui.presentation.nav_graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.medicineapp.core.ui.presentation.MEDICINE_GRAPH_ROUTE
import com.example.medicineapp.core.ui.presentation.Screen
import com.example.medicineapp.login.presentation.ui.LoginScreen
import com.example.medicineapp.medicine_details.presentation.ui.MedicineDetails
import com.example.medicineapp.medicine_list.presentation.ui.MedicineList
import com.example.medicineapp.medicine_list.presentation.viewmodel.MedicineViewModel

fun NavGraphBuilder.singInNavGraph(navController: NavController) {
    navigation(
        startDestination = Screen.SignIn.route,
        route = MEDICINE_GRAPH_ROUTE
    ) {
        composable(
            route = Screen.SignIn.route
        ) {
            LoginScreen(navController)
        }
        composable(
            route = Screen.MedicineList.route
        ) {
            val viewModel = it.sharedViewModel<MedicineViewModel>(navController)

            MedicineList(navController,viewModel)
        }
        composable(
            route = Screen.MedicineDetails.route,
        ) {
            val viewModel = it.sharedViewModel<MedicineViewModel>(navController)

            MedicineDetails(navController,viewModel)
        }
    }
}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(navController: NavController): T {
    val navGraphRoute = destination.parent?.route ?: return hiltViewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }

    return hiltViewModel(parentEntry)
}