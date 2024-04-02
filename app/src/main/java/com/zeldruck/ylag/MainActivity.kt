package com.zeldruck.ylag

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zeldruck.ylag.presentation.calendar.CalendarScreen
import com.zeldruck.ylag.presentation.home.HomeScreen
import com.zeldruck.ylag.presentation.nav.components.NavigationBar
import com.zeldruck.ylag.presentation.profile.ProfileScreen
import com.zeldruck.ylag.ui.theme.YourLifeAsAGameTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YourLifeAsAGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DefaultPreview()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    val navController = rememberNavController()

    Scaffold(bottomBar = { NavigationBar(navController) }) {
        MainScreenNavigationConfigurations(navController = navController)
    }
}

@Composable
private fun MainScreenNavigationConfigurations(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = "Home")
    {
        composable("Home")
        {
            HomeScreen();
        }

        composable("Schedule")
        {
            CalendarScreen()
        }

        composable("Achievements")
        {
            HomeScreen()
        }

        composable("Profile")
        {
            ProfileScreen()
        }
    }
}