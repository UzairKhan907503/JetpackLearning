package com.example.jetpacklearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
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

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackLearningTheme {
        SetView()
    }
}