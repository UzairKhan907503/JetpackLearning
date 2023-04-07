package com.example.jetpacklearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpacklearning.ui.theme.JetpackLearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetView()
        }
    }
}

@Composable
fun SetView() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(300.dp)
            .fillMaxHeight(.70f)
            .background(
                Color.Green
            ),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text("Uzair")
        Text(text = "Khan")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackLearningTheme {
        SetView()
    }
}