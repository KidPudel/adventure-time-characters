package com.example.adventure_time_characters.di

import com.example.adventure_time_characters.common.Constants
import com.example.adventure_time_characters.data.remote.ICharactersApi
import com.example.adventure_time_characters.data.repositories.CharactersRepository
import com.example.adventure_time_characters.domain.irepositories.ICharactersRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {
    @Binds
    @Singleton
    fun getCharactersRepository(charactersRepository: CharactersRepository) : ICharactersRepository

    companion object {
        private val charactersApi: ICharactersApi? = null
        @Provides
        @Singleton
        fun getCharactersApi(): ICharactersApi {
            charactersApi?.let { return it }
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ICharactersApi::class.java)
        }
    }
}