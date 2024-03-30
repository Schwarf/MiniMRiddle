package abs.apps.minimriddle

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "easter") {
        composable("easter") {HelloMartaScreen {navController.navigate("password") }}
        composable("password") { PasswordScreen { navController.navigate("numbers") } }
        composable("numbers") { NumberInputScreen { navController.navigate("images") } }
        composable("images") { Finale() }
    }
}