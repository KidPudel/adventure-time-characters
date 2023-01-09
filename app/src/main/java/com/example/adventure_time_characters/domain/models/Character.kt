package com.example.adventure_time_characters.domain.models

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import retrofit2.http.Url
import java.net.URL

data class Character(
    val name: String,
    val fullName: String,
    val species: String,
    val age: Int,
    val sex: String,
    val quotes: List<String>,
    val image: String
)

/*fun Character.decodeImage(): ImageBitmap {
    val url = URL(image)
    val bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())
    return bitmap.asImageBitmap()
}*/
