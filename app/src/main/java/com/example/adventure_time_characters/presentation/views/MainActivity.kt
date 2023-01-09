package com.example.adventure_time_characters.presentation.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.adventure_time_characters.common.MyColors
import com.example.adventure_time_characters.ui.theme.AdventuretimecharactersTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdventuretimecharactersTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MyColors.BakerMilkerPink
                ) {
                    CharacterList()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AdventuretimecharactersTheme {
        Greeting("Android")
    }
}