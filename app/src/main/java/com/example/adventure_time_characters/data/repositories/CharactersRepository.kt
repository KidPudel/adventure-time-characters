package com.example.adventure_time_characters.data.repositories

import android.util.Log
import com.example.adventure_time_characters.data.remote.ICharactersApi
import com.example.adventure_time_characters.data.remote.dto.CharacterDto
import com.example.adventure_time_characters.domain.irepositories.ICharactersRepository
import okhttp3.internal.EMPTY_RESPONSE
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class CharactersRepository @Inject constructor(private val api: ICharactersApi) :
    ICharactersRepository {
    override suspend fun getCharacters(): List<CharacterDto> {
        val response = try {
            api.getCharacters()
        } catch (e: IOException) {
            Log.e("IO error", "You may not have internet connection ;(")
            null
        }
        response?.let { return it.body() ?: emptyList() } ?: return emptyList()
    }

    override suspend fun getCharacter(name: String): CharacterDto {
        val response = try {
            api.getCharacter(name)
        } catch (e: IOException) {
            Log.e("IO error", "You may not have internet connection ;(")
            null
        }

        response?.let {
            if (it.isSuccessful) {
                return it.body() ?: CharacterDto(
                    name = "",
                    fullName = "",
                    species = "",
                    age = 0,
                    sex = "",
                    quotes = emptyList(),
                    image = ""
                )
            } else return CharacterDto(
                name = "",
                fullName = "",
                species = "",
                age = 0,
                sex = "",
                quotes = emptyList(),
                image = ""
            )
        } ?: return CharacterDto(
            name = "",
            fullName = "",
            species = "",
            age = 0,
            sex = "",
            quotes = emptyList(),
            image = ""
        )
    }

}