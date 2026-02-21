package com.bebedirasoi.ui.screens.meal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bebedirasoi.data.model.Meal

@Composable
fun MealDetailScreen(meal: Meal) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(meal.title)
        Text(meal.description)
        Text("Ingredients: ${meal.ingredients.joinToString()}")
        Text("Calories: ${meal.calories}")
        Text("Price: ₹${meal.price}")
        Text("Rating: ${meal.rating}")
    }
}
