package com.example.adventure_time_characters.presentation.views.character_detail

import com.example.adventure_time_characters.data.remote.dto.CharacterDto
import com.example.adventure_time_characters.domain.models.Character

data class CharacterDetailState(
    val character: Character = Character(
        name = "",
        fullName = "",
        species = "",
        age = 0,
        sex = "",
        quotes = emptyList(),
        image = ""
    )
)
