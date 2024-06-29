package com.example.apuntes_jetpackcompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apuntes_jetpackcompose.viewmodel.MainViewModel
import com.google.android.gms.wallet.button.ButtonConstants

@Composable
fun CounterScreen(mainViewModel: MainViewModel ) {
    // UI that reacts to state changes

    Column (
        modifier = Modifier.fillMaxSize()
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ){
        Text(text = "Contador: ${mainViewModel.cuenta.value}")
        Button(
            onClick = { mainViewModel.increment() },

            /**
             *  .combinedClickable(
             *                 onClick = {
             *                     Toast
             *                         .makeText(context, "Click simple", Toast.LENGTH_SHORT)
             *                         .show()
             *                 },
             *                 onLongClick = {
             *                     Toast
             *                         .makeText(context, "Long Click", Toast.LENGTH_SHORT)
             *                         .show()
             *                 },
             *                 onDoubleClick = {
             *                     Toast
             *                         .makeText(context, "Doble Click", Toast.LENGTH_SHORT)
             *                         .show()
             *                 },
             *             )
             */
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = Color.Red,
                contentColor = Color.White
        )) {
            Text("Contar")
        }
    }
}