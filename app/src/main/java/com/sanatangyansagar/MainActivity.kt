package com.sanatangyansagar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.ads.MobileAds
import com.sanatangyansagar.Navigation.NavGraph
import com.sanatangyansagar.ui.theme.SanatanGyanSagarTheme
import dagger.hilt.android.AndroidEntryPoint
import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SanatanApplication : Application()
@AndroidEntryPoint // Added for Hilt Dependency Injection
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Initialize Google Mobile Ads
        MobileAds.initialize(this) {}

        enableEdgeToEdge()

        setContent {
            SanatanGyanSagarTheme {
                // 2. Initialize the NavController
                val navController = rememberNavController()

                // 3. Set the NavGraph as the root content
                NavGraph(navController = navController)
            }
        }
    }
}