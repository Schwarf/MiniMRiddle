package abs.apps.minimriddle

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import abs.apps.minimriddle.ui.theme.MiniMRiddleTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

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
fun PasswordScreen(onPasswordCorrect: () -> Unit) {
    // State to hold the password input
    var password by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Du willst also unseren Schatz? Dann musst Du das Passwort kennen!")
        Image(
            painter = painterResource(R.drawable.Chest),
            contentDescription = null, // Provide a description if needed
            modifier = Modifier
                .fillMaxSize() // Set the size of the image if needed
        )
        Text(text = "Den ersten Hinweis hat Tante Chia-Wei!")
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Geheimes Passwort") }
        )
        Button(onClick = {
            if (password == "Hallo") {
                onPasswordCorrect()
            } else {
                // Show error or do something
            }
        }) {
            Text("Submit")
        }
    }
}


@Composable
fun NumberInputScreen(onPasswordCorrect: () -> Unit) {

}

@Composable
fun Finale() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Der Schatz wird von Emmie bewacht. Finde Emmie!")
    }
}