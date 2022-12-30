package com.example.adventure_time_characters.data.remote

import com.example.adventure_time_characters.data.remote.dto.CharacterDto
import retrofit2.http.GET

/**
 * Define API routes app accesses
 */
interface ICharactersApi {
    @GET("/characters")
    suspend fun getCharacters() : List<CharacterDto>
}