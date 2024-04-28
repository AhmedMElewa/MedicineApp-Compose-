package com.example.medicineapp.core.ui.presentation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.medicineapp.core.ui.presentation.MEDICINE_GRAPH_ROUTE
import com.example.medicineapp.core.ui.presentation.ROOT_GRAPH_ROUTE

@Composable
fun SetupNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = MEDICINE_GRAPH_ROUTE,
        route = ROOT_GRAPH_ROUTE
    ) {
        singInNavGraph(navController)
    }
}