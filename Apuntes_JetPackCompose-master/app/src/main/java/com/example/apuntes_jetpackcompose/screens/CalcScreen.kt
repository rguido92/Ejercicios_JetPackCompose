package com.example.apuntes_jetpackcompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.apuntes_jetpackcompose.R
import com.example.apuntes_jetpackcompose.btn_back
import com.example.apuntes_jetpackcompose.viewmodel.calcViewModel

@Composable
fun calcScreen(navController: NavController) {
    CalculBodyContent(navController)
}

@Composable
fun CalculBodyContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        calculadora()
        btn_back(navController = navController)

    }


}

@Composable
@Preview(showSystemUi = true)
// Define una función llamada calculadora que no toma ningún argumento y no devuelve nada.
fun calculadora() {
    var calc: calcViewModel = viewModel()


    // Declara una variable para almacenar la operación seleccionada, inicializada en SUMA.

    // Llama a la función textFieldConEstado para crear dos campos de texto que capturan los números ingresados.
    textFieldConEstado(num = 1.0, number = calc.firstNumber.value) { value ->
        calc.firstNumber.value = value
    }
    textFieldConEstado(num = 2.0, number = calc.secondNumber.value) { value ->
        calc.secondNumber.value = value
    }

    // Crea un grupo de botones de radio para seleccionar la operación matemática deseada.
    Column {
        OperationRadioButton(
            text = stringResource(R.string.sumar),
            selected = calc.selectedOperation.value == Operation.SUM,
            onSelected = { calc.selectedOperation.value  = Operation.SUM }
        )
        OperationRadioButton(
            text = stringResource(R.string.restar),
            selected = calc.selectedOperation.value  == Operation.SUBTRACT,
            onSelected = { calc.selectedOperation.value  = Operation.SUBTRACT }
        )
        OperationRadioButton(
            text = stringResource(R.string.multiplicar),
            selected = calc.selectedOperation.value  == Operation.MULTIPLY,
            onSelected = { calc.selectedOperation.value  = Operation.MULTIPLY }
        )
        OperationRadioButton(
            text = stringResource(R.string.dividir),
            selected = calc.selectedOperation.value  == Operation.DIVIDE,
            onSelected = { calc.selectedOperation.value  = Operation.DIVIDE }
        )
    }

    // Crea un botón "Calcular" que ejecuta la operación seleccionada y muestra el resultado.
    Button(onClick = {
       calc.operation(calc.selectedOperation.value )

    }) {
        Text(text = stringResource(R.string.calcular))
    }

    // Muestra el resultado de la operación.
    Text(
        modifier = Modifier.padding(20.dp),
        fontSize = 20.sp,
        color = calc.changeColor(calc.result.value),
        text = "${stringResource(R.string.resultado)}: ${calc.result.value}"
    )
}

// Enumera los tipos de operaciones matemáticas posibles.
enum class Operation {
    SUM, SUBTRACT, MULTIPLY, DIVIDE
}

// Define una función componible para un botón de radio de operación.
@Composable
fun OperationRadioButton(
    text: String,
    selected: Boolean,
    onSelected: () -> Unit
) {
    // Crea un botón de radio para la operación especificada.
    Row(
        Modifier
            .selectable(
                selected = selected,
                onClick = onSelected
            )
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = onSelected
        )
        Text(text = text)
    }
}

@Composable
fun textFieldConEstado(num: Double, number: String, onNumberChange: (String) -> Unit) {
    var textFieldValue by remember { mutableStateOf("") }
    TextField(
        value = textFieldValue,
        onValueChange = {
            textFieldValue = it
            onNumberChange(it)
        },
        label = { Text("${stringResource(R.string.numero)}  $num") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

