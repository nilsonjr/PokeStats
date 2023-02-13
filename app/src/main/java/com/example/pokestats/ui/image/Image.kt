package com.example.pokestats.ui.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.pokestats.R

@Composable
fun SimpleImageComponent(id: Int, description: String, width: Int, height: Int) {
    Image(
        painter = painterResource(id),
        contentDescription = description,
        modifier = Modifier
            .width(width.dp)
            .height(height.dp)
    )
}

@Composable
fun SimpleImageComponent(id: Int, description: String, dimensions: Int) {
    Image(
        painter = painterResource(id),
        contentDescription = description,
        modifier = Modifier
            .width(dimensions.dp)
            .height(dimensions.dp)
    )
}

@Composable
fun MainScreenSocials(id: Int, description: String) {
    SimpleImageComponent(id = id, description = description, dimensions = 35)
}

@Composable
fun ComplexWebImageComponent(link: String) {
    val context = LocalContext.current
    AsyncImage(
        model = ImageRequest.Builder(context)
            .data(link)
            .placeholder(R.drawable.baseline_image_24)
            .crossfade(true)
            .crossfade(500)
            .error(R.drawable.baseline_image_24)
            .build(),
        contentScale = ContentScale.Crop,
        contentDescription = "Card Image",
        modifier = Modifier.size(72.dp)
    )
}