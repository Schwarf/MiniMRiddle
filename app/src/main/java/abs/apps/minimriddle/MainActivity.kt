package abs.apps.minimriddle

import abs.apps.minimriddle.ui.theme.MiniMRiddleTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiniMRiddleTheme {
                Scaffold {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun DigitOnlyTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = {
            // Check if the new value consists only of digits before updating
            if (it.all { char -> char.isDigit() }) {
                onValueChange(it)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        label = { Text("Geheimer Zahlencode") }
        // Add other parameters like Modifier as needed
    )
}

@Composable
fun NumberInputScreen(onPasswordCorrect: () -> Unit) {
    var password by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false)  }
    Box(modifier = Modifier.fillMaxSize()) {
        // Background image setup
        Image(
            painter = painterResource(R.drawable.flying),
            contentDescription = null, // Background image does not require a description
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )


        // Use Modifier.fillMaxHeight() on Column to make it take the entire height
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp)
                .align(Alignment.Center),
            verticalArrangement = Arrangement.SpaceBetween // This will space the children evenly
        ) {
            Text(
                text = "Noch hast Du unseren Schatz nicht, hahaha! Jetzt brauchst Du Zahlen.",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 20.sp
                ),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.weight(0.6f)) // This adds flexible space between text and input
            Text(
                text = "Nur ein Mannheimer kann Dir weiterhelfen.",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 20.sp
                ),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.weight(1f)) // This adds flexible space between text and input

            // Keep the input field and button closer to each other
            Column {
                DigitOnlyTextField(value = password, onValueChange = { password = it })
                Button(onClick = {
                    if (password == "10271802") {
                        onPasswordCorrect()
                    } else {
                        showDialog = true
                    }
                }) {
                    Text("Zahlencode abschicken!")
                }

            }
            Spacer(modifier = Modifier.weight(0.5f)) // This adds flexible space between text and input
        }
    }
    if (showDialog)
        ShowIncorrectPasswordDialog (onDismiss = {showDialog = false})


}

@Composable
fun Finale() {
    Box(modifier = Modifier.fillMaxSize()) {
        // Background image setup
        Image(
            painter = painterResource(R.drawable.emmie),
            contentDescription = null, // Background image does not require a description
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Der Schatz wird von Emmie bewacht. Finde Emmie!",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                ),
            )

        }
    }
}

@Composable
fun PasswordScreen(onPasswordCorrect: () -> Unit) {
    // State to hold the password input
    var password by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false)  }
    Box(modifier = Modifier.fillMaxSize()) {
        // Background image setup
        Image(
            painter = painterResource(R.drawable.chest),
            contentDescription = null, // Background image does not require a description
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )


        // Use Modifier.fillMaxHeight() on Column to make it take the entire height
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp)
                .align(Alignment.Center),
            verticalArrangement = Arrangement.SpaceBetween // This will space the children evenly
        ) {
            Text(
                text = "Du willst also unseren Schatz? Dann musst Du das Passwort kennen!",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 20.sp
                ),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.weight(0.6f)) // This adds flexible space between text and input
            Text(
                text = "Nur Taiwaner kennen das erste Geheimnis des Passworts",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 20.sp
                ),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.weight(1f)) // This adds flexible space between text and input

            // Keep the input field and button closer to each other
            Column {
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Geheimes Passwort eingeben") }
                )
                val inputPassword = password.trim().replace("\\s".toRegex(), "").toLowerCase()
                Button(onClick = {
                    if (inputPassword == "pulk") {
                        onPasswordCorrect()
                    } else {
                       showDialog = true
                    }
                }) {
                    Text("Passwort abschicken!")
                }

            }
            Spacer(modifier = Modifier.weight(0.5f)) // This adds flexible space between text and input
        }
    }
    if (showDialog)
        ShowIncorrectPasswordDialog (onDismiss = {showDialog = false})
}



@Composable
fun HelloMartaScreen(onButtonClick : () -> Unit) {
        Box(modifier = Modifier.fillMaxSize()) {
            // Background image setup
            Image(
                painter = painterResource(R.drawable.easterbunny),
                contentDescription = null, // Background image does not require a description
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
            )
            Column(modifier = Modifier.padding(16.dp)) {
            Spacer(modifier = Modifier.weight(1f)) // This adds flexible space between text and input
            Text(
                text = "Hallo Marta, hilfst Du mir den Schatz von den gemeinen Knödelmon zurückzuholen.",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 30.sp
                ),
            )
            Button(onClick = {onButtonClick()},
                ) {
                Text(text = "Ja!")
            }
        }
    }
}

@Composable
fun ShowIncorrectPasswordDialog(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = {},
        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.laughing),
                    contentDescription = "Error",
                    modifier = Modifier.fillMaxWidth().height(200.dp).clip(shape = RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Text(text = "Das war leider falsch.")

            }
        },
        confirmButton = {
            Button(
                onClick = { onDismiss() }
            ) {
                Text(text = "Nochmal probieren.")
            }
        }
    )
}