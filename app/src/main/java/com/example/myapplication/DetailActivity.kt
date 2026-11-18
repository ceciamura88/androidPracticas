package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val name = intent.getStringExtra("USER_NAME")
                val age = intent.getIntExtra("USER_AGE",0)
                Column(modifier = Modifier.padding(20.dp)){

                    texto2(name, age)
                }

            }
        }
    }
}

@Composable
fun texto2(name: String?, age: Int){
    Column(){
        Row(){
            Text(
                text = "Nombre:"
            )
            Text(
                text = "$name"
            )
        }
        Row(){
            Text(
                text = "Edad:"
            )
            Text(
                text = "$age"
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MyApplicationTheme {
        texto2("Ceci", 34)
    }
}