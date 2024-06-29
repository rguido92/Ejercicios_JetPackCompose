package com.example.apuntes_jetpackcompose.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.apuntes_jetpackcompose.screens.calcScreen
import com.example.apuntes_jetpackcompose.screens.calcSimple
import com.example.apuntes_jetpackcompose.screens.firstScreen
import com.example.apuntes_jetpackcompose.screens.secondScreen

import com.example.apuntes_jetpackcompose.screens.CounterScreen
import com.example.apuntes_jetpackcompose.viewmodel.MainViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.firstScreen.route) {
        composable(route = AppScreens.firstScreen.route) {
            firstScreen(navController)
        }
        composable(
            route = AppScreens.secondScreen.route, // para pasar un parametro de una pantalla a otra, usar text y arguments
        ) {
            secondScreen(navController)
        }
        composable(route = AppScreens.calcScreen.route) {
            calcScreen(navController)
        }
        composable(route = AppScreens.calcSimple.route) {
            calcSimple(navController)
        }
        composable(route = AppScreens.contadorViewModel.route) {
            CounterScreen(mainViewModel = MainViewModel())
        }
    }
}