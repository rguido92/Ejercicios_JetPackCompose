package com.example.apuntes_jetpackcompose.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val cuenta: MutableState<Int> =  mutableStateOf(0) //solución al problema anterior para que no resetee
    var counterState = mutableStateOf(0)
    fun increment() {
        cuenta.value++
    }
}