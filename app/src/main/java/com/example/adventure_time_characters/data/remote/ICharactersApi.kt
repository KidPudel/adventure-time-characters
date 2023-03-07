package com.example.adventure_time_characters.data.remote

import com.example.adventure_time_characters.data.remote.dto.CharacterDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Define API routes app accesses
 */
interface ICharactersApi {
    @GET("/characters")
    suspend fun getCharacters() : Response<List<CharacterDto>>

    @GET("/character/{name}")
    suspend fun getCharacter(@Path("name") name: String) : Response<CharacterDto>
}