package com.example.adventure_time_characters.domain.irepositories

import com.example.adventure_time_characters.data.remote.dto.CharacterDto
import retrofit2.http.GET

interface ICharactersRepository {

    suspend fun getCharacters() : List<CharacterDto>
}