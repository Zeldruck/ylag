package com.zeldruck.ylag

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.zeldruck.ylag.data.CEvent
import com.zeldruck.ylag.data.CEventsDatabase
import com.zeldruck.ylag.presentation.calendar.CEventsViewModel
import com.zeldruck.ylag.presentation.calendar.CalendarScreen
import com.zeldruck.ylag.presentation.home.HomeScreen
import com.zeldruck.ylag.presentation.nav.components.NavigationBar
import com.zeldruck.ylag.presentation.profile.ProfileScreen
import com.zeldruck.ylag.ui.theme.YourLifeAsAGameTheme


class MainActivity : ComponentActivity() {

    private val database by lazy {
        Room.databaseBuilder(
            applicationContext,
            CEventsDatabase::class.java,
            "cevents.db"
        ).build()
    }

    private val viewModel by viewModels<CEventsViewModel>(
        factoryProducer = {
            object: ViewModelProvider.Factory {
                override fun<T: ViewModel> create(modelClass: Class<T>): T {
                    return CEventsViewModel(database.dao) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YourLifeAsAGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val state by viewModel.state.collectAsState()
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "Home")
                    {
                        composable("Home")
                        {
                            HomeScreen(
                                state = state,
                                navController = navController,
                                navHostController = navController,
                                onEvent = viewModel::OnEvent
                            )
                        }

                        composable("Schedule")
                        {
                            CalendarScreen(
                                state = state,
                                navController = navController,
                                navHostController = navController,
                                onEvent = viewModel::OnEvent
                            )
                        }

                        composable("ATask")
                        {
                            /*ATaskScreen(
                                state = state,
                                navController = navController,
                                onEvent = viewModel::OnEvent
                            )*/
                        }

                        composable("Achievements")
                        {
                            //HomeScreen()
                        }

                        composable("Profile")
                        {
                            ProfileScreen()
                        }
                    }
                }
            }
        }
    }
}