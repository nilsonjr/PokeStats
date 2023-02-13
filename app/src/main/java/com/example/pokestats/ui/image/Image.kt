package com.example.pokestats.ui.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

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