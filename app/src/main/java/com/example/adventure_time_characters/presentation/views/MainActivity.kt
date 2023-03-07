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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.adventure_time_characters.common.MyColors
import com.example.adventure_time_characters.presentation.views.character_detail.CharacterDetail
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
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.CharacterListScreen.route) {
                        composable(route = Screen.CharacterListScreen.route) {
                            CharacterList()
                        }
                        composable(route = Screen.CharacterDetailScreen.route, arguments = listOf(
                            navArgument("name") {
                                type = NavType.StringType
                                defaultValue = "Iggy :3"
                                nullable = true
                            }
                        )) {
                            CharacterDetail(name = it.arguments?.getString("name") ?: "")
                        }
                    }
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