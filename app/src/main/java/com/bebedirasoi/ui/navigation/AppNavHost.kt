package com.bebedirasoi.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bebedirasoi.ui.screens.admin.AdminDashboardScreen
import com.bebedirasoi.ui.screens.cart.CartScreen
import com.bebedirasoi.ui.screens.checkout.CheckoutScreen
import com.bebedirasoi.ui.screens.home.HomeScreen
import com.bebedirasoi.ui.screens.onboarding.OnboardingScreen
import com.bebedirasoi.ui.screens.order.OrderConfirmationScreen
import com.bebedirasoi.ui.screens.order.OrderTrackingScreen
import com.bebedirasoi.ui.screens.profile.ProfileScreen
import com.bebedirasoi.ui.screens.splash.SplashScreen
import com.bebedirasoi.ui.viewmodel.CartViewModel

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    val cartViewModel = remember { CartViewModel() }

    NavHost(navController = navController, startDestination = Routes.Splash) {
        composable(Routes.Splash) { 
            SplashScreen { 
                navController.navigate(Routes.Onboarding) {
                    popUpTo(Routes.Splash) { inclusive = true }
                }
            } 
        }
        composable(Routes.Onboarding) { 
            OnboardingScreen { 
                navController.navigate(Routes.Home) {
                    popUpTo(Routes.Onboarding) { inclusive = true }
                }
            } 
        }
        // Auth screen is skipped for now
        composable(Routes.Home) { 
            HomeScreen(cartViewModel = cartViewModel) { route ->
                navController.navigate(route)
            } 
        }
        composable(Routes.Cart) { 
            CartScreen(cartViewModel) { 
                navController.navigate(Routes.Checkout) 
            } 
        }
        composable(Routes.Checkout) { 
            CheckoutScreen(cartViewModel) { 
                navController.navigate(Routes.Confirmation) 
            } 
        }
        composable(Routes.Confirmation) { 
            OrderConfirmationScreen { 
                navController.navigate(Routes.Tracking) 
            } 
        }
        composable(Routes.Tracking) { OrderTrackingScreen() }
        composable(Routes.Profile) { 
            ProfileScreen { 
                navController.navigate(Routes.Admin) 
            } 
        }
        composable(Routes.Admin) { AdminDashboardScreen() }
    }
}
