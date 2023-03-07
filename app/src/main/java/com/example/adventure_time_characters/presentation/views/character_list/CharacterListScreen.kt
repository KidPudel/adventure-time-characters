package com.example.adventure_time_characters.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.adventure_time_characters.R
import com.example.adventure_time_characters.common.MyColors
import com.example.adventure_time_characters.presentation.view_models.CharacterViewModel

@Composable
fun CharacterList() {
    val characterViewModel: CharacterViewModel = hiltViewModel()
    val boldText = FontWeight.Bold
    val textSize = 16.sp
    if (characterViewModel.state.value.characters.isNotEmpty()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            state = rememberLazyListState(),
            userScrollEnabled = true
        ) {
            items(characterViewModel.state.value.characters) { character ->
                Card(
                    shape = RoundedCornerShape(1.dp),
                    backgroundColor = MyColors.SpanishLavender,
                    modifier = Modifier.border(
                        width = 5.dp,
                        color = Color.Black
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(modifier = Modifier.width(16.dp))
                        AsyncImage(
                            model = character.image,
                            contentDescription = character.fullName,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .size(106.dp)
                                .background(
                                    color = MyColors.LightCyan
                                )
                                .border(width = 2.dp, color = Color.Black)
                                .padding(2.dp)
                                .border(width = 5.dp, color = MyColors.SelectiveYellow)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text(
                                text = character.fullName,
                                fontWeight = boldText,
                                fontSize = textSize,
                                color = MyColors.LightCyan
                            )
                            Text(
                                text = character.age.toString(),
                                fontWeight = boldText,
                                fontSize = textSize,
                                color = MyColors.LightCyan
                            )
                            Text(
                                text = character.sex,
                                fontWeight = boldText,
                                fontSize = textSize,
                                color = MyColors.LightCyan
                            )

                        }
                    }


                }
                Spacer(modifier = Modifier.height(5.dp))
            }
        }

    }
}