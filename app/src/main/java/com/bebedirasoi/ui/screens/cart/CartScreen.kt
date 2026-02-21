package com.bebedirasoi.ui.screens.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bebedirasoi.ui.viewmodel.CartViewModel

@Composable
fun CartScreen(vm: CartViewModel, onCheckout: () -> Unit) {
    val items = vm.cart.value
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.SpaceBetween) {
        LazyColumn {
            items(items) {
                Text("${it.meal.title} x${it.quantity} - ₹${it.meal.price * it.quantity}")
            }
        }
        Column {
            Text("Total: ₹${vm.totalAmount()}")
            Button(onClick = onCheckout) { Text("Proceed to Checkout") }
        }
    }
}
