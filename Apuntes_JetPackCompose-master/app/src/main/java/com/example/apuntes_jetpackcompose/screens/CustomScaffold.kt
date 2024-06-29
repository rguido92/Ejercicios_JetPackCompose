@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.apuntes_jetpackcompose.screens

import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apuntes_jetpackcompose.viewmodel.MainViewModel
import com.example.apuntes_jetpackcompose.viewmodel.calcViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random

// Función Composable que crea un Scaffold personalizado
@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun CustomScaffold() {
    var scaffoldBackgroundColor by remember { mutableStateOf(Color.White) }

    Scaffold(
        // Barra superior
        topBar = { CustomTopBar() },

        // Barra inferior
        bottomBar = { CustomBottomBar() },

        // Botón flotante personalizado
        floatingActionButton = {
            CustomFAB(
                onButtonClick = { scaffoldBackgroundColor = Color(Random.nextLong(0xFFFFFFFF)) }
            )
        },

        // Contenido principal
        content = { padding ->
            CustomContent(padding)
        },

        containerColor = scaffoldBackgroundColor
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar() {
    TopAppBar(
        colors = topAppBarColors(
            MaterialTheme.colorScheme.primary
        ),
        // Título de la barra superior
        title = {
            Text(
                text = "" + LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm:ss a"))
            )
        }
    )
}

@Composable
fun CustomBottomBar() {
    BottomAppBar(content = {
        // Contenido de la barra inferior
        Text(text = "Ej. Scaffold-Bottom->Item One")
    },
        containerColor = MaterialTheme.colorScheme.primary)
}

@Composable
fun CustomFAB(
    onButtonClick: () -> Unit
) {
    val context = LocalContext.current
    FloatingActionButton(
        // Color de fondo
        containerColor = MaterialTheme.colorScheme.primary,
        // Acción al hacer clic en el botón (sin definir)
        onClick = { /*TODO*/
            onButtonClick()
            Toast.makeText(context, "Click simple en boton Scaffold", Toast.LENGTH_SHORT).show()
        }
    ) {
        Text(
            fontSize = 24.sp, // Tamaño de fuente del texto del botón
            text = "+" // Texto del botón
        )
    }
}


@Composable
fun CustomContent(padding: PaddingValues) {
    val context = LocalContext.current
    Column(
        // Modificadores de estilo de la columna
        modifier = Modifier
            // Ocupar todo el espacio disponible
            .fillMaxSize()
            .padding(padding),

        // Contenido de la aplicación
        content = {
            Text(text = "My app content")
            Button(
                onClick = {
                    Toast.makeText(
                        context,
                        "Click simple en boton Cuerpo Scaffold",
                        Toast.LENGTH_SHORT
                    ).show()
//                    Ej06Screen()
                }
            ) {
                Text(text = "Navegar")
            }
        }
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ExampleTopAppBar() {
    var mainViewModel : MainViewModel = viewModel()
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Abrir menú desplegable")
            }
        },
        title = {
            Text(
                text = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm:ss a"))
            )
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favorito")
            }
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Buscar")
            }
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Más")
            }
        },

        )
}
@Preview
@Composable
fun CustomFAB() {
    var context = LocalContext.current
    FloatingActionButton(
        // Color de fondo
        contentColor = MaterialTheme.colorScheme.primary,
        // Acción al hacer clic en el botón (sin definir)
        onClick = {
            Toast.makeText(context, "fab pulsado", Toast.LENGTH_SHORT).show()

        }
    ) {
        Log.e("fab", "entra")
        Text(
            fontSize = 24.sp, // Tamaño de fuente del texto del botón
            text = "+" // Texto del botón
        )
    }
}

@Preview
@Composable
 fun MainBottomBar() {
    BottomAppBar(
        actions = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Outlined.MoreVert,
                    contentDescription = "Ver más"
                )
            }
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Outlined.Delete,
                    contentDescription = "Eliminar"
                )
            }
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Outlined.LocationOn,
                    contentDescription = "Localizar"
                )
            }
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Buscar"
                )
            }
        },
//        floatingActionButton = {
//            FloatingActionButton(onClick = { }) {
//                Icon(
//                    imageVector = Icons.Default.Add,
//                    contentDescription = "Agregar"
//                )
//            }
//        }
    )
}


