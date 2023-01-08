package com.example.adventure_time_characters.presentation.view_models

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adventure_time_characters.domain.use_cases.GetCharactersUseCase
import com.example.adventure_time_characters.presentation.CharacterListState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(val getCharactersUseCase: GetCharactersUseCase): ViewModel() {

    private val _state = mutableStateOf(CharacterListState())
    fun getCharacters() {
        viewModelScope.launch {
            getCharactersUseCase.getCharacters().collectLatest {
                _state.value.characters = it
            }
        }
    }
}