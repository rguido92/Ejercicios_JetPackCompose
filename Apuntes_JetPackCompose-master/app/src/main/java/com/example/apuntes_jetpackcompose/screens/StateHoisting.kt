package com.example.apuntes_jetpackcompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable

/**
 * https://developer.android.com/jetpack/compose/state-hoisting?hl=es-419
 */
// SIN ELEVACION DE ESTADO
@Composable
fun MainScreen1() {
    MutableBooleanScreen()
}

@Composable
fun MutableBooleanScreen() {
    val boolean = rememberSaveable { mutableStateOf(true) }
    Column {
        Button(
            onClick = {
                boolean.value = !boolean.value
            }
        ) {
            Text(text = "Click")
        }
        Text(text = boolean.value.toString())
    }
}


// CON ELEVACION DE ESTADO
@Composable
fun MainScreen2() {
    val boolean = rememberSaveable { mutableStateOf(true) }
    ImmutableBooleanScreen(boolean.value) {
        boolean.value = !boolean.value
    }
}

@Composable
fun ImmutableBooleanScreen(
    boolean: Boolean,
    onClick: () -> Unit,
) {
    Column {
        Button(
            onClick = {
                onClick()
            }
        ) {
            Text(text = "Click")
        }
        Text(text = boolean.toString())
    }
}