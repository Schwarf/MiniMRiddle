package abs.apps.minimriddle

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import abs.apps.minimriddle.ui.theme.MiniMRiddleTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
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
fun NumberInputScreen(onPasswordCorrect: () -> Unit) {
    var password by remember { mutableStateOf("") }

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
                Button(onClick = {
                    if (password == "Oster-Pulk") {
                        onPasswordCorrect()
                    } else {
                        // Handle incorrect password
                    }
                }) {
                    Text("Passwort abschicken!")
                }

            }
            Spacer(modifier = Modifier.weight(0.5f)) // This adds flexible space between text and input
        }
    }

}

@Composable
fun Finale() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Der Schatz wird von Emmie bewacht. Finde Emmie!")
        Image(
            painter = painterResource(R.drawable.emmie),
            contentDescription = null, // Provide a description if needed
            modifier = Modifier
                .fillMaxSize() // Set the size of the image if needed
        )

    }
}

@Composable
fun PasswordScreen(onPasswordCorrect: () -> Unit) {
    // State to hold the password input
    var password by remember { mutableStateOf("") }

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
                Button(onClick = {
                    if (password == "Oster-Pulk") {
                        onPasswordCorrect()
                    } else {
                        // Handle incorrect password
                    }
                }) {
                    Text("Passwort abschicken!")
                }

            }
            Spacer(modifier = Modifier.weight(0.5f)) // This adds flexible space between text and input
        }
    }
}
