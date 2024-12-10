package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.DropBoxManager
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("CicloDeVida", "onCreate() llamado")
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "first_screen") {
                    composable("first_screen") { firstScreen(navController) }
                    composable("second_screen") { secondScreen(navController) }

                }

            }

                }

            }
    override fun onStart() {
        super.onStart()
        Log.d("CicloDeVida", "onStart() llamado")
    }
    override fun onResume() {
        super.onResume()
        Log.d("CicloDeVida", "onResume() llamado")
    }
    override fun onPause() {
        super.onPause()
        Log.d("CicloDeVida", "onPause() llamado")
    }
    override fun onStop() {
        super.onStop()
        Log.d("CicloDeVida", "onStop() llamado")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("CicloDeVida", "onRestart() llamado")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("CicloDeVida", "onDestroy() llamado")
    }
        }


    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Bienvenido, $name!",
            modifier = modifier
        )
    }



@Composable
fun firstScreen(navController : NavController) {
    val showMenu = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            painter = painterResource(id = R.drawable.icono),
            contentDescription = "Imagen pantalla inicial",
            modifier = Modifier
                .size(250.dp)
                .border(1.dp, Color.Red)
                .clickable {
                    showMenu.value = true
                }
        )
        Text(
            text = "Pantalla inicial",
            color = Color.Blue
        )

        DropdownMenu(
            expanded = showMenu.value,
            onDismissRequest = { showMenu.value = false},
            modifier = Modifier.padding(8.dp)
        ) {
            Text (
                text = "Acabas de hacer click en la imagen",
                modifier = Modifier
                .padding(8.dp)
                    .clickable {
                        showMenu.value = false
                    }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("second_screen")},
        ){
            Text(
                text = "Ir a la segunda pantalla"
            )
        }
    }

}

@Composable
fun DropDowMenu() {

}

@Composable
fun secondScreen(navController : NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = "Pantalla secundaria",
            color = Color.Red
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {navController.navigate("first_screen")}) {
            Text(
                text= "Ir a la pantalla principal"
            )
        }
    }
}
    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        MyApplicationTheme {
            Greeting("Agra")
        }
    }
