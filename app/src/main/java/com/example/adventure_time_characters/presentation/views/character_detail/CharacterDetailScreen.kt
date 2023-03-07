package com.example.adventure_time_characters.presentation.views.character_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.adventure_time_characters.common.MyColors
import com.example.adventure_time_characters.domain.models.Character
import com.example.adventure_time_characters.presentation.view_models.CharacterViewModel

@Composable
fun CharacterDetails(name: String) {
    val characterViewModel: CharacterViewModel = hiltViewModel()
    characterViewModel.getCharacter(name = name)
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .border(
                width = 10.dp,
                color = Color.Black
            ), backgroundColor = MyColors.SpanishLavender
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            characterViewModel.state.value.character.apply {
                AsyncImage(
                    model = image,
                    contentDescription = fullName,
                    modifier = Modifier
                        .size(126.dp)
                        .border(width = 5.dp, color = Color.Black)
                        .padding(5.dp)
                        .background(color = MyColors.LightCyan)
                        .border(width = 5.dp, color = MyColors.SelectiveYellow)
                        .padding(5.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "$fullName ($name)",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = MyColors.LightCyan
                )
                Spacer(modifier = Modifier.height(20.dp))
                Divider(color = Color.Black, thickness = 5.dp)
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Info:",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MyColors.LightCyan,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                )
                Spacer(modifier = Modifier.height(10.dp))
                val boldText = FontWeight.Bold
                val fontSize = 16.sp
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .background(color = MyColors.LightCyan)
                        .border(width = 5.dp, color = Color.Black)
                        .padding(5.dp)
                        .border(width = 5.dp, color = MyColors.SelectiveYellow)
                ) {
                    Column(
                        modifier = Modifier
                            .background(color = MyColors.LightCyan)
                            .border(width = 5.dp, color = Color.Black)
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "species: $species",
                            fontWeight = boldText,
                            fontSize = fontSize,
                            color = MyColors.SpanishLavender
                        )
                        Text(
                            text = "age: $age",
                            fontWeight = boldText,
                            fontSize = fontSize,
                            color = MyColors.SpanishLavender
                        )
                        Text(
                            text = "gender: $sex",
                            fontWeight = boldText,
                            fontSize = fontSize,
                            color = MyColors.SpanishLavender
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Quotes:",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MyColors.LightCyan,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Left
                )
                Spacer(modifier = Modifier.height(10.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .background(color = MyColors.LightCyan)
                        .border(width = 5.dp, color = Color.Black)
                        .padding(5.dp)
                        .border(width = 5.dp, color = MyColors.SelectiveYellow)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = MyColors.LightCyan)
                            .border(width = 5.dp, color = Color.Black)
                    ) {
                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                            for (quote in quotes) {
                                Text(text = quote, fontWeight = FontWeight.Bold, color = MyColors.SpanishLavender)
                                Divider(color = MyColors.SpanishLavender, thickness = 2.dp)
                            }
                        }
                    }

                }

            }


        }
    }

}