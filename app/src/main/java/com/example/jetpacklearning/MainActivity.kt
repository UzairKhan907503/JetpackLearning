package com.example.jetpacklearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
        modifier = Modifier
            .background(Color.Green)
            .fillMaxWidth()
            .fillMaxHeight(.5f)
            .padding(top = 50.dp)
            .border(width = 5.dp, color = Color.Black)
            .padding(10.dp)
            .border(width = 5.dp, color = Color.Blue)

    ) {
        Text("Uzair", modifier = Modifier.offset(0.dp, 20.dp).clickable {

        })
        Spacer(modifier = Modifier.height(50.dp))
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