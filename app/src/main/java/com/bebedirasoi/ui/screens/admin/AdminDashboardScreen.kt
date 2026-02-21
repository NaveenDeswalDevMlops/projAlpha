package com.bebedirasoi.ui.screens.admin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AdminDashboardScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Admin Dashboard")
        Text("• Add / Edit / Delete meals")
        Text("• Update daily availability")
        Text("• View orders")
        Text("• Change status: Preparing / Out for delivery / Delivered")
    }
}
