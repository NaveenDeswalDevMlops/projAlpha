package com.bebedirasoi.ui.screens.checkout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bebedirasoi.ui.viewmodel.CartViewModel

@Composable
fun CheckoutScreen(vm: CartViewModel, onPaymentSuccess: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Choose Delivery Slot")
        Text("• 12:30 PM - 1:30 PM")
        Text("• 7:00 PM - 8:30 PM")
        Text("Payment: Razorpay")
        Button(onClick = {
            vm.clear()
            onPaymentSuccess()
        }, modifier = Modifier.padding(top = 16.dp)) {
            Text("Pay ₹${vm.totalAmount()}")
        }
    }
}
