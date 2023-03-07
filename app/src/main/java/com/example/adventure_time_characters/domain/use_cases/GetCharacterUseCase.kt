package com.example.adventure_time_characters.domain.use_cases

import com.example.adventure_time_characters.data.remote.dto.toCharacter
import com.example.adventure_time_characters.domain.irepositories.ICharactersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.example.adventure_time_characters.domain.models.Character

class GetCharacterUseCase @Inject constructor(private val repository: ICharactersRepository) {
    fun getCharacter(name: String): Flow<Character> = flow {
        val character = repository.getCharacter(name)
        emit(character.toCharacter())
    }
}