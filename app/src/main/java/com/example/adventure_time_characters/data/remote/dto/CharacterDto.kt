package com.example.adventure_time_characters.data.remote.dto

import com.example.adventure_time_characters.domain.models.Character

data class CharacterDto(
    val name: String,
    val fullName: String,
    val species: String,
    val age: Int,
    val sex: String,
    val quotes: List<String>,
    val image: String
)

/**
 * convert fetched from api data to models used in app
 */
fun CharacterDto.toCharacter(): Character {
    return Character(name, fullName, species, age, sex, quotes, image)
}