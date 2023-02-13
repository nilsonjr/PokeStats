package com.example.pokestats.cardscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokestats.cardscreen.ui.theme.PokeStatsTheme
import com.example.pokestats.ui.card.ItemCardComponent

class CardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokeStatsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        ItemCardComponent(
                            1,
                            "PETR4",
                            12.00,
                            2.57,
                            -0.12,
                            0.00,
                            "https://seeklogo.com/images/P/Petrobras-logo-03DABEE0AC-seeklogo.com.png"
                        )
                        ItemCardComponent(
                            2,
                            "PKST1",
                            4.72,
                            5.48,
                            1.89,
                            2.44,
                            "https://www.kindpng.com/picc/m/346-3463544_pokeball-drawing-free-download-pokemon-master-ball-png.png"
                        )
                    }
                }
            }
        }
    }
}