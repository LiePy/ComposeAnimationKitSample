package com.lie.sdktest

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.lie.composeanimationkit.AnimationKit
import com.lie.composeanimationkit.animation.RotationAnimation
import com.lie.sdktest.ui.theme.SDKTestTheme
import com.lie.composeanimationkit.view.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SDKTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val context = LocalContext.current
    Column {
        Text(text = "Hello, $name!")

        AnimationKit.LoadingAnimation.RotationAnimation{
            Box(modifier = Modifier.background(Color.Green)) {
                Text(text = "I am rotation")
            }
        }

        Button(onClick = {
            context.startActivity(Intent(context, com.lie.composeanimationkit.activity.MainActivity::class.java))
        }) {
            Text(text = "Test")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SDKTestTheme {
        Greeting("Android")
    }
}