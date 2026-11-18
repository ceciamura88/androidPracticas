package com.example.myapplication

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val context = LocalContext.current

                val intent = Intent(
                    context,
                  DetailActivity::class.java
                )
                intent.putExtra("USER_NAME", "CECIKLIA")
                intent.putExtra("USER_AGE", 35)
                context.startActivity(intent)


                // 1. Crear Intent con Acción
                val intent2 = Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.7749,-122.4194?q=Restaurante")).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, "¡Hola!")
                }
// 2. Ejecutar con protección anti-crash
                try {
                    context.startActivity(intent2)
                } catch (e: ActivityNotFoundException) {
// Manejar caso donde no hay app compatible
                    Toast.makeText(context, "Sin app compatible",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {

    }
}