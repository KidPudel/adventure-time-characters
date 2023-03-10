package com.example.adventure_time_characters.presentation.view_models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adventure_time_characters.domain.use_cases.GetCharactersUseCase
import com.example.adventure_time_characters.presentation.views.character_list.CharacterListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CharacterListState())
    val state: MutableState<CharacterListState>
        get() = _state

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch(context = Dispatchers.IO) {
            getCharactersUseCase.getCharacters().collectLatest {
                _state.value = CharacterListState(characters = it)
            }
        }
    }
}