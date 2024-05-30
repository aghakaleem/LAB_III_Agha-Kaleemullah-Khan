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
    fun LoginScreen(nav:NavController) {
        val primaryColor = Color(red = 37, blue = 144, green = 174);
        val buttonColor = Color(red = 237, green = 238, blue = 242);
        val emailValue = remember {
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
//        Email TextField
            TextField(value = emailValue.value, onValueChange = {
                emailValue.value = it
            }, label = { Text(text = "Enter Email") })
            Spacer(modifier = Modifier.height(16.dp))

//        Password Field
            TextField(value = passwordValue.value, onValueChange = {
                passwordValue.value = it
            },
                label = { Text(text = "Enter Password") })
            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = { },
                colors =
                ButtonDefaults.buttonColors(containerColor = buttonColor),
                modifier = Modifier.fillMaxWidth(0.71F),
                shape = RectangleShape
            ) {
                Text(text = "Login", color = primaryColor)
            }
            Spacer(modifier = Modifier.height(48.dp))
            Text(
                color = Color.White,
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle()){
                        append("Not a Member? ")
                    }
                    withStyle(style = SpanStyle(),) {
                        append("Sign up now",)
                    }
                }, modifier = Modifier.clickable {
                    nav.popBackStack()
                })
        }
    }