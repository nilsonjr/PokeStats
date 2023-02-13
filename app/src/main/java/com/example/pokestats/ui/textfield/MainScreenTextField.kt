package com.example.pokestats.ui.textfield

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.pokestats.R

@Composable
fun ModernTextField(
    fieldName: String,
    placeholder: String,
    iconVector: ImageVector,
    iconDescription: String
) {
    val text = remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        value = text.value,
        onValueChange = {
            text.value = it
        },
        modifier = Modifier
            .fillMaxWidth(),
        label = {
            Text(text = fieldName)
        },
        placeholder = {
            Text(text = placeholder, color = colorResource(id = R.color.main_text_field_placeholder))
        },
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.DarkGray,
            focusedLabelColor = colorResource(id = R.color.main_text_field_secondary),
            unfocusedLabelColor = colorResource(id = R.color.main_text_field_primary),
            leadingIconColor = colorResource(id = R.color.main_text_field_secondary),
            backgroundColor = colorResource(id = R.color.main_text_field_background)
        ),
        leadingIcon = {
            Icon(
                imageVector = iconVector,
                contentDescription = iconDescription,
                tint = colorResource(id = R.color.main_text_field_secondary)
            )
        },
        keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus()}),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
    )
}

@Composable
fun ModernPasswordField(
    fieldName: String,
    placeholder: String,
    iconVector: ImageVector,
    iconDescription: String
) {
    val text = remember { mutableStateOf("") }
    val passwordVisible = remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        value = text.value,
        onValueChange = {
            text.value = it
        },
        modifier = Modifier
            .fillMaxWidth(),
        label = {
            Text(text = fieldName)
        },
        placeholder = {
            Text(text = placeholder, color = colorResource(id = R.color.main_text_field_placeholder))
        },
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.DarkGray,
            focusedLabelColor = colorResource(id = R.color.main_text_field_secondary),
            unfocusedLabelColor = colorResource(id = R.color.main_text_field_primary),
            leadingIconColor = colorResource(id = R.color.main_text_field_secondary),
            backgroundColor = colorResource(id = R.color.main_text_field_background)
        ),
        leadingIcon = {
            Icon(
                imageVector = iconVector,
                contentDescription = iconDescription
            )
        },
        keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus()}),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        visualTransformation =
            if (!passwordVisible.value) PasswordVisualTransformation()
            else VisualTransformation.None,
        trailingIcon = {
            val image =
                if (passwordVisible.value)
                    Icons.Filled.Visibility
                else
                    Icons.Filled.VisibilityOff
            IconButton(onClick = {
                passwordVisible.value = !passwordVisible.value
            }) {
                Icon(
                    imageVector = image,
                    contentDescription = "Password Visible Description"
                )
            }
        }
    )
}