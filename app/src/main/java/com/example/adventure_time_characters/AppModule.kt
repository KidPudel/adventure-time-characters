package com.example.adventure_time_characters

import com.example.adventure_time_characters.common.Constants
import com.example.adventure_time_characters.data.remote.ICharactersApi
import com.example.adventure_time_characters.data.repositories.CharactersRepository
import com.example.adventure_time_characters.domain.irepositories.ICharactersRepository
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
object AppModule {
    @Provides
    @Singleton
    fun getCharactersApi(): ICharactersApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create<ICharactersApi>()
    }

    @Provides
    @Singleton
    fun getCharactersRepository(api: ICharactersApi): CharactersRepository {
        return CharactersRepository(api)
    }
}