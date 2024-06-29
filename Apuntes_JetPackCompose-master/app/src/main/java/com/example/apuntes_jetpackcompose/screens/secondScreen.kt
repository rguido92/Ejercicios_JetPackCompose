package com.example.apuntes_jetpackcompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.apuntes_jetpackcompose.btn_back

@Composable
fun secondScreen(navController: NavController) {
    // componente grafico para estructurar una pantalla
    SecondBodyContent(navController)

    // componente grafico para estructurar una pantalla
//        Scaffold(topBar = {
//            TopAppBar() {
//                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Arrow back",
//                    modifier = Modifier.clickable {
//                        navController.popBackStack()
//                    })
//                Spacer(modifier = Modifier.width(8.dp))
//                Text(text = "SecondScreen")
//            }
//        }
//        ) {

//        }
}


@Composable
fun SecondBodyContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BotonContador2()
        btn_back(navController = navController)

    }

}


@Composable
fun BotonContador2() {
    var count by rememberSaveable { mutableStateOf(0) }
    Text("$count", fontSize = 40.sp)
    Row(Modifier.padding(10.dp)) {
        Button(onClick = { count++ }, Modifier.padding(10.dp),enabled = count<10) {
            Text("Add one")
        }
        Button(onClick = { count = 0 }, Modifier.padding(10.dp)) {
            Text(text = "Reset")
        }
    }


}

@Composable
fun BotonContador1(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var count by remember { mutableStateOf(0) }

        Text("$count")
        Button(onClick = { count++ }, Modifier.padding(top = 8.dp)) {
            Text("Add one")
        }
    }
}

@Composable
fun BotonContador3(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var count by rememberSaveable { mutableStateOf(0) }

        Text("$count")
        Button(onClick = { count++ }, Modifier.padding(top = 8.dp)) {
            Text("Add one")
        }
    }
}

