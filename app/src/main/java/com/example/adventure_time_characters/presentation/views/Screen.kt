package com.example.adventure_time_characters.presentation.views

sealed class Screen(val route: String) {
    object CharacterListScreen : Screen(route = "character_list_screen")
    object CharacterDetailScreen : Screen(route = "character_detail_screen")
}
