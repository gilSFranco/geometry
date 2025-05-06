package com.fatec.geometry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.fatec.geometry.ui.navigation.AppNavigation
import com.fatec.geometry.ui.theme.GeometryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GeometryTheme {
                AppNavigation()
            }
        }
    }
}