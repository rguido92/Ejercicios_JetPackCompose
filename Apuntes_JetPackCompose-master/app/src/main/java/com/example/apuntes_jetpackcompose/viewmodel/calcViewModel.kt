package com.example.apuntes_jetpackcompose.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.apuntes_jetpackcompose.screens.Operation

class calcViewModel : ViewModel() {
    // Declara tres variables para almacenar el primer número, el segundo número y el resultado de la operación.
    //var firstNumber by remember { mutableStateOf("") }
    // var secondNumber by remember { mutableStateOf("") }
    // var result by remember { mutableStateOf(0.0) }
    var firstNumber = mutableStateOf("")
    var secondNumber = mutableStateOf("")
    var result = mutableDoubleStateOf(0.0)
    var selectedOperation = mutableStateOf(Operation.SUBTRACT)


    fun operation(selectedOperation: Operation) {
        val firstValue = firstNumber.value.toDouble()
        val secondValue = secondNumber.value.toDouble()
        result.value = when (selectedOperation) {
            Operation.SUM -> firstValue + secondValue
            Operation.SUBTRACT -> firstValue - secondValue
            Operation.MULTIPLY -> firstValue * secondValue
            Operation.DIVIDE -> firstValue / secondValue
        }
    }

    fun changeColor(value: Double): androidx.compose.ui.graphics.Color {
        if (value > 25) {
            return androidx.compose.ui.graphics.Color.Blue
        } else if (value < 25) {
            return androidx.compose.ui.graphics.Color.Cyan
        } else
            if (value == 25.0) {

                return androidx.compose.ui.graphics.Color.Red
            } else return androidx.compose.ui.graphics.Color.Black
    }
}