package com.example.pokestats.ui.button

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.pokestats.R
import com.example.pokestats.cardscreen.CardActivity
import com.example.pokestats.ui.image.MainScreenSocials

@Composable
fun LoginButton() {
    val context = LocalContext.current
    Button(
        modifier = Modifier
            .width(200.dp)
            .height(40.dp),
        onClick = {
            val intent = Intent(context, CardActivity::class.java)
            context.startActivity(intent)
            //Toast.makeText(context, "Login check", Toast.LENGTH_LONG).show()
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.main_text_field_secondary),
            contentColor = colorResource(id = R.color.white)
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text = "Login")
    }
}

@Composable
fun SignUpButton() {
    val context = LocalContext.current
    Button(
        modifier = Modifier
            .width(200.dp)
            .height(40.dp),
        onClick = {
            Toast.makeText(context, "Page redirection", Toast.LENGTH_LONG).show()
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.main_text_field_primary),
            contentColor = colorResource(id = R.color.white)
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text = "Sign Up")
    }
}

@Composable
fun MainScreenIconButton(id: Int, description: String) {
    IconButton(
        onClick = {

        }
    ) {
        MainScreenSocials(id = id, description = description)
    }
}

@Composable
fun TextButtonComponent(text: String) {
    TextButton(
        onClick = {

        }
    ) {
        Text(text = text)
    }
}

@Composable
fun TextButtonWithIconComponent(expanded: Boolean, clickMethod: () -> Unit) {
    val vectorId = if (expanded) R.drawable.baseline_arrow_upward_24 else R.drawable.baseline_arrow_downward_24
    val text = if (expanded) "Less" else "More"
    TextButton(
        onClick = clickMethod,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = vectorId),
            contentDescription = "Expand Card Button"
        )
        Text(text = text)
    }
}