package com.example.pokestats.ui.card

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokestats.R
import com.example.pokestats.ui.button.TextButtonWithIconComponent
import com.example.pokestats.ui.image.SimpleImageComponent

@Composable
fun ItemCardComponent(
    id: Int,
    textLabel: String,
    currentValue: Double,
    variationHour: Double,
    variationDay: Double,
    variationMonth: Double
) {
    var isExpanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(text = id.toString(), fontSize = 48.sp, modifier = Modifier.padding(4.dp))
                SimpleImageComponent(id = R.drawable.master_ball, description = "Card Image", dimensions = 72)
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CardComponentMainText(text = textLabel)
                }
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.End
                ) {
                    CardComponentMainText(text = getValueText(currentValue))
                    CardComponentPercentileText(value = variationHour)
                }
            }
            TextButtonWithIconComponent(
                expanded = isExpanded,
                clickMethod = {
                    isExpanded = !isExpanded
                }
            )
            if (isExpanded) {
                Divider(modifier = Modifier.padding(4.dp), color = Color.Transparent)
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ValueHistoryRow(label = "Last Hour", value = variationHour)
                    ValueHistoryRow(label = "Last Day", value = variationDay)
                    ValueHistoryRow(label = "Last Hour", value = variationMonth)
                }
            }
        }
    }
}

@Composable
fun CardComponentMainText(text: String) {
    Text(
        text = text,
        fontSize = 24.sp
    )
}

@Composable
fun CardComponentHistoryText(text: String) {
    Text(
        text = text,
        fontSize = 20.sp,
        textAlign = TextAlign.Start
    )
}

@Composable
fun CardComponentPercentileText(value: Double) {
    Text(
        text = String.format("%.2f %%", value),
        fontSize = 14.sp,
        color = getValueBasedColor(value),
        textAlign = TextAlign.End
    )
}

@Composable
fun ValueHistoryRow(label: String, value: Double) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        CardComponentHistoryText(text = label)
        CardComponentPercentileText(value = value)
    }
}

private fun getValueBasedColor(value: Double): Color {
    if (value > 0) return Color.Green
    if (value < 0) return Color.Red
    return Color.Yellow
}

private fun getValueText(value: Double): String {
    return String.format("R$ %.2f", value)
}