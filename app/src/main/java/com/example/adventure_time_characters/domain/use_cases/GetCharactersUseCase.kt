package com.example.adventure_time_characters.domain.use_cases

import com.example.adventure_time_characters.data.remote.dto.toCharacter
import com.example.adventure_time_characters.data.repositories.CharactersRepository
import com.example.adventure_time_characters.domain.models.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCharactersUseCas @Inject constructor(val repository: CharactersRepository) {
    suspend fun getCharacters(): Flow<List<Character>> = flow {
        val characters = repository.getCharacters()
        emit(characters.map {it.toCharacter()})
    }
}