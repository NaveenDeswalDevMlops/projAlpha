package com.bebedirasoi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.bebedirasoi.core.theme.BebeDiRasoiTheme
import com.bebedirasoi.ui.navigation.AppNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BebeDiRasoiTheme {
                Surface {
                    AppNavHost()
                }
            }
        }
    }
}
