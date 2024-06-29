package com.example.apuntes_jetpackcompose.screens

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.apuntes_jetpackcompose.navigation.AppScreens

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun firstScreen(navController: NavController) {

    Scaffold(topBar = { ExampleTopAppBar() },
        bottomBar = { MainBottomBar()},
        //floatingActionButton = { CustomFAB() },
        content = {
            firstBodyContent(navController)

        },
        floatingActionButton =  {CustomFAB()}

    )

}


@Composable
fun firstBodyContent(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            navController.navigate(route = AppScreens.secondScreen.route)
        }) {
            Text("Contador")
        }
        Button(onClick = {
            navController.navigate(route = AppScreens.calcScreen.route)
        }) {
            Text("Calculadora")
        }
        Button(onClick = {
            navController.navigate(route = AppScreens.calcSimple.route)
        }) {
            Text("Calculadora simple")
        }
        Button(onClick = {
            navController.navigate(route = AppScreens.contadorViewModel.route)
        }) {
            Text("Contador con viewModel")
        }


    }


}
