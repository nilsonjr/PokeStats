package com.example.pokestats.mainscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokestats.R
import com.example.pokestats.ui.button.LoginButton
import com.example.pokestats.ui.button.MainScreenIconButton
import com.example.pokestats.ui.button.SignUpButton
import com.example.pokestats.ui.button.TextButtonComponent
import com.example.pokestats.ui.image.SimpleImageComponent
import com.example.pokestats.ui.textfield.ModernPasswordField
import com.example.pokestats.ui.textfield.ModernTextField
import com.example.pokestats.ui.theme.PokeStatsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokeStatsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(60.dp)
                    ) {
                        SimpleImageComponent(
                            id = R.drawable.master_ball,
                            description = "Main Screen Icon",
                            150
                        )
                        Divider(modifier = Modifier.padding(20.dp), color = Color.Transparent)
                        ModernTextField(
                            fieldName = getString(R.string.field_text_login),
                            placeholder = "Input your login",
                            iconVector = Icons.Outlined.Person,
                            iconDescription = "Outlined Login Icon"
                        )
                        ModernPasswordField(
                            fieldName = "Password",
                            placeholder = "Input your password",
                            iconVector = Icons.Filled.Lock,
                            iconDescription = "Outlined Password Icon"
                        )
                        Divider(modifier = Modifier.padding(8.dp), color = Color.Transparent)
                        LoginButton()
                        Divider(modifier = Modifier.padding(2.dp), color = Color.Transparent)
                        SignUpButton()
                        Divider(modifier = Modifier.padding(8.dp), color = Color.Transparent)
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .width(200.dp)
                                .padding(8.dp)
                        ) {
                            MainScreenIconButton(id = R.drawable.google, description = "Gmail button")
                            MainScreenIconButton(id = R.drawable.facebook, description = "Facebook button")
                            MainScreenIconButton(id = R.drawable.instagram, description = "Instagram button")
                        }
                        Divider(modifier = Modifier.padding(48.dp), color = Color.Transparent)
                    }
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        TextButtonComponent(text = "Forgot My Password")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PokeStatsTheme {
    }
}