package com.bebedirasoi.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bebedirasoi.data.model.Meal
import com.bebedirasoi.ui.navigation.Routes
import com.bebedirasoi.ui.viewmodel.CartViewModel
import com.bebedirasoi.ui.viewmodel.HomeViewModel

@Composable
fun HomeScreen(cartViewModel: CartViewModel, onNavigate: (String) -> Unit, vm: HomeViewModel = hiltViewModel()) {
    val meals = vm.state.value.meals.ifEmpty {
        listOf(
            Meal(id = "1", title = "Punjabi Thali", description = "Dal, sabzi, roti, chawal", price = 99.0, calories = 750, rating = 4.8),
            Meal(id = "2", title = "Rajma Chawal", description = "Comfort meal", price = 79.0, calories = 680, rating = 4.7)
        )
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Today's Thali")
        LazyColumn {
            items(meals) { meal ->
                Card(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp).clickable {
                    cartViewModel.addItem(meal)
                    onNavigate(Routes.Cart)
                }) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(meal.title)
                        Text("₹${meal.price} • ${meal.calories} kcal • ⭐ ${meal.rating}")
                    }
                }
            }
        }
    }
}
