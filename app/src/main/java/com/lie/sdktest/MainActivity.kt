package com.lie.sdktest

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lie.composeanimationkit.AnimationKit
import com.lie.composeanimationkit.animation.RadarSearchAnimation
import com.lie.composeanimationkit.animation.RippleSearchAnimation
import com.lie.composeanimationkit.animation.RotationAnimation
import com.lie.sdktest.ui.theme.SDKTestTheme

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
                    MainContent()
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainContent() {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(150.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            BorderBox {
                AnimationKit.SearchAnimation.RippleSearchAnimation()
            }
        }
        item {
            BorderBox {
                AnimationKit.SearchAnimation.RadarSearchAnimation()
            }
        }
        item {
            BorderBox {
                AnimationKit.LoadingAnimation.RotationAnimation(
                    modifier = Modifier.size(150.dp)
                ) {
                    Text(text = "I'm Roting~", modifier = Modifier.align(Alignment.Center))
                }
            }
        }
    }
}

@Composable
fun BorderBox(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier.border(0.5.dp, Color.Gray),
        contentAlignment = Alignment.Center
    )
    {
        content()
    }
}