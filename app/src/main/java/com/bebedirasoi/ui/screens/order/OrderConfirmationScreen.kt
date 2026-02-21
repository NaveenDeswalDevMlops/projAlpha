package com.bebedirasoi.ui.screens.order

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OrderConfirmationScreen(onTrackOrder: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Order Confirmed 🎉")
        Text("Your ghar-jaisa meal is now being prepared.")
        Button(onClick = onTrackOrder, modifier = Modifier.padding(top = 12.dp)) { Text("Track Order") }
    }
}
