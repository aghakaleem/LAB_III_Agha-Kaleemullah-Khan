package com.example.lab3

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SignUpScreen(nav:NavController) {
    val primaryColor = Color(red = 45, green = 50, blue = 54);
    val buttonColor = Color(red = 234, green = 76, blue=135);
    val textFieldColors = TextFieldDefaults.colors(
        focusedTextColor = Color.White,
        unfocusedTextColor = Color.White,
        unfocusedContainerColor = Color(red = 60, green = 64, blue = 75),
        focusedContainerColor = Color(red = 60, green = 64, blue = 75),
        unfocusedLabelColor = Color.Gray,
        focusedLabelColor = Color.Gray,
    )

    val emailValue = remember {
        mutableStateOf("")
    }
    val nameValue = remember {
        mutableStateOf("")
    }

    val passwordValue = remember {
        mutableStateOf("")
    }





    Column(
        modifier = Modifier
            .background(color = primaryColor)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        TextField(
            colors = textFieldColors,
            value = nameValue.value, onValueChange = {
                nameValue.value = it
            }, label = { Text(text = "Fullname") })
        Spacer(modifier = Modifier.height(16.dp))

//        Email TextField
        TextField(
            colors = textFieldColors,
            value = emailValue.value, onValueChange = {
                emailValue.value = it
            }, label = { Text(text = "Email") })
        Spacer(modifier = Modifier.height(16.dp))

//        Password Field
        TextField(
            colors = textFieldColors,
            value = passwordValue.value, onValueChange = {
                passwordValue.value = it
            },
            label = { Text(text = "Password") })
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = { },
            colors =
            ButtonDefaults.buttonColors(containerColor = buttonColor),
            modifier = Modifier.fillMaxWidth(0.71F),
            shape = RectangleShape
        ) {
            Text(text = "Register", color = Color.White)
        }
        Spacer(modifier = Modifier.height(48.dp))
        Text(
            color = Color.White,
            text = buildAnnotatedString {
                withStyle(style = SpanStyle()){
                    append("Already Registered? ")
                }
                withStyle(style = SpanStyle()) {
                    append("Login Here")
                }
            }, modifier = Modifier.clickable {
                nav.navigate("/login")
            })
    }
}