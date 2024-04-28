package com.example.medicineapp.core.ui.presentation

const val ROOT_GRAPH_ROUTE = "root"
const val MEDICINE_GRAPH_ROUTE = "MEDICINE"

sealed class Screen(val route: String) {
    object SignIn : Screen(route = "sign_in")
    object MedicineList : Screen(route = "medicine_list")
    object MedicineDetails : Screen(route = "medicine_details")
}
