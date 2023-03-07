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
import androidx.navigation.NavArgument
import androidx.navigation.NavArgumentBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.adventure_time_characters.common.MyColors
import com.example.adventure_time_characters.presentation.views.character_detail.CharacterDetails
import com.example.adventure_time_characters.ui.theme.AdventuretimecharactersTheme
import dagger.hilt.android.AndroidEntryPoint
import com.example.adventure_time_characters.domain.models.Character

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
                            CharacterList(navController = navController)
                        }
                        composable(route = Screen.CharacterDetailScreen.route + "/{name}", arguments = listOf(
                            navArgument(name = "name") {
                                type = NavType.StringType
                                nullable = true
                            }
                        )) {
                            CharacterDetails(name = it.arguments?.getString("name") ?: "")
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