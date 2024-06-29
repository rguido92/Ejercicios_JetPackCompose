package com.example.apuntes_jetpackcompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.res.stringResource
import com.example.apuntes_jetpackcompose.R
import com.example.apuntes_jetpackcompose.btn_back

@Composable
fun calcSimple(navController: NavController) {
    // Declara tres variables para almacenar el primer número, el segundo número y el resultado de la operación.
    var firstNumber by remember { mutableStateOf("") }
    var secondNumber by remember { mutableStateOf("") }
    var result by remember { mutableStateOf(0.0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Llama a la función textFieldConEstado para crear dos campos de texto que capturan los números ingresados.
        textFieldConEstado(num = 1.0, number = firstNumber) { value ->
            firstNumber = value
        }
        textFieldConEstado(num = 2.0, number = secondNumber) { value ->
            secondNumber = value
        }
        // Crea un botón "Calcular" que ejecuta la operación seleccionada y muestra el resultado.
        Button(onClick = {
            result = firstNumber.toDouble() + secondNumber.toDouble()
        }) {
            Text(text = stringResource(R.string.calcular))
        }
        // Muestra el resultado de la operación.
        Text(
            modifier = Modifier.padding(20.dp),
            fontSize = 20.sp,
            text = "Resultado: $result"
        )
        btn_back(navController = navController)
    }


}