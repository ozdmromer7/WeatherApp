package com.eryaz.weatherdataparsetrying.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            LazyColumn {
                items(20){

                    LambdaFunctionUnderstanding(name = "Omer", surname = "Bartu"){

                    }
                }
            }
        }
    }
}

@Composable
fun LambdaFunctionUnderstanding(
    name: String,
    surname: String,
    onClick: (String) -> Unit)
{
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = name)
        Text(text = surname)
        Button(onClick = { onClick("$name $surname") }) {
            Text(text = name)
        }
    }

}

