package com.example.adventure_time_characters.presentation
import com.example.adventure_time_characters.domain.models.Character
data class CharacterListState(
    var characters: List<Character> = emptyList()
)
