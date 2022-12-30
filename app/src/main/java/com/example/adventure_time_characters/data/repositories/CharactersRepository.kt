package com.example.adventure_time_characters.data.repositories

import com.example.adventure_time_characters.data.remote.ICharactersApi
import com.example.adventure_time_characters.data.remote.dto.CharacterDto
import com.example.adventure_time_characters.domain.irepositories.ICharactersRepository
import javax.inject.Inject

class CharactersRepository @Inject constructor(val api: ICharactersApi): ICharactersRepository {
    override suspend fun getCharacters(): List<CharacterDto> {
        return api.getCharacters()
    }
}