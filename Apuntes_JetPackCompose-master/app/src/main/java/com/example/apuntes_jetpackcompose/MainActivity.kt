package com.example.apuntes_jetpackcompose

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Top
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.core.util.Preconditions
import androidx.navigation.NavController
import com.example.apuntes_jetpackcompose.navigation.AppNavigation

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun app() {

    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.LightGray)
    ) {

        Button(
            onClick = { /*TODO*/ }, modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(30.dp)
        ) {
            Text(text = "Button")
        }

    }

}

@Preview(showBackground = true)
@Composable
fun lazyColum() {
    LazyColumn {
        items(50) {
            Text(
                text = "item $it",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier
                    .padding(2.dp)
                    .background(Color.DarkGray)
                    .fillMaxSize()
                    .padding(20.dp)
            )
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun ejercicioColumn1() {
    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = "Texto 1", modifier = Modifier
                .background(Color.Yellow)
        )
        Text(
            text = "Texto 2", modifier = Modifier
                .background(Color.Green)
        )
        Text(
            text = "Texto 3", modifier = Modifier
                .background(Color.Cyan)
        )


    }
}

//@Preview(showBackground = true)
@Composable
fun ejercicioColumn2() {
    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Texto1",
            modifier = Modifier
                .background(Color.Red)
                .weight(0.25f)
        )
        Text(
            text = "Texto 2", modifier = Modifier
                .background(Color.Green)
                .weight(0.25f)
                .fillMaxWidth()
        )
        Text(
            text = "Texto 3", modifier = Modifier
                .background(Color.Cyan)
                .weight(0.5f)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun ejercicioColumn3() {
    Row(
        modifier = Modifier
            .background(Color.Cyan)
            .fillMaxSize()
            .padding(30.dp), horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "JetPack Compose",
            modifier = Modifier
                .background(Color.Magenta)
                .align(Top)
        )

    }
    Row() {
        Text(
            text = "Texto hardcodeado"
        )
    }
}

@Composable
fun btn_back(navController: NavController) {

    Button(onClick = {
        navController.popBackStack()
    }) {
        Text("Volver atrás")
    }


}