package com.example.adventure_time_characters.domain.models

data class Character(
    val name: String,
    val fullName: String,
    val species: String,
    val age: Int,
    val sex: String,
    val quotes: List<String>,
    val image: String
)
