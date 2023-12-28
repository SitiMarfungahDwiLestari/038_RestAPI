package com.example.consumerestapi.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.example.consumerestapi.ui.kontak.screen.DestinasiEntry
import com.example.consumerestapi.ui.kontak.screen.DestinasiHome
import com.example.consumerestapi.ui.kontak.screen.EntryKontakScreen
import com.example.consumerestapi.ui.kontak.screen.HomeScreen

@Composable
fun PengelolaHalaman(navController: NavHostController = rememberNavController()){
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier,
    ){
        composable(DestinasiHome.route){
            HomeScreen(
                navigateToItemEntry = {
                    navController.navigate(DestinasiEntry.route)
                },
                onDetailClick = {})
        }
        composable(DestinasiEntry.route){
            EntryKontakScreen(navigateBack = { navController.navigate(DestinasiHome.route){
                popUpTo((DestinasiHome.route){
                    inclusive = true
                })
            } })
        }
    }
}