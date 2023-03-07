package com.example.adventure_time_characters.presentation.view_models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adventure_time_characters.domain.use_cases.GetCharacterUseCase
import com.example.adventure_time_characters.presentation.views.character_detail.CharacterDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val useCase: GetCharacterUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CharacterDetailState())
    val state: MutableState<CharacterDetailState>
        get() = _state


    fun getCharacter(name: String) {
        viewModelScope.launch {
            useCase.getCharacter(name = name).collectLatest {
                _state.value = CharacterDetailState(it)
            }
        }
    }
}