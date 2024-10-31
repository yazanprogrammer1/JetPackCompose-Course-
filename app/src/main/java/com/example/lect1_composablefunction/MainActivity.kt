package com.example.lect1_composablefunction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.lect1_composablefunction.ui.theme.Lect1_ComposableFunctionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lect1_ComposableFunctionTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyButton()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyLayout() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        MyText()
        MyButton()
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "Loop...")
            MyImage()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MyText() {
    Text(
        text = "Elephants can sense storms",
        style = TextStyle(
            color = Color.Blue,
            fontSize = 24.sp,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Center
        ),
        maxLines = 2
    )
}

@Preview
@Composable
fun MyButton() {
    var buttonEnabled by remember { mutableStateOf(true) }
    Button(
        onClick = { buttonEnabled = !buttonEnabled },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Green,
            contentColor = Color.Red,
            disabledContainerColor = Color.Yellow,
            disabledContentColor = Color.Blue
        ),
        enabled = buttonEnabled
    ) {
        Text(
            text = if (buttonEnabled) "Click Me" else "disabled!"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyTextField() {
    var emailAddress by remember { mutableStateOf("") }

    TextField(
        value = emailAddress,
        onValueChange = {
            emailAddress = it
        },
        label = {
            Text(text = "Email Address")
        },
        maxLines = 1,
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Green,
            unfocusedTextColor = Color.Blue,
            focusedContainerColor = Color.Yellow,
            unfocusedContainerColor = Color.Red,
            cursorColor = Color.Green
        ),
    )
}

@Preview(showBackground = true)
@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "This is icon app"
    )
}
