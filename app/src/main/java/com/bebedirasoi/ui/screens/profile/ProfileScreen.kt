package com.bebedirasoi.ui.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(onAdminClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Profile")
        Text("Address: Add / Edit address")
        Text("Order history available")
        Button(onClick = onAdminClick, modifier = Modifier.padding(top = 8.dp)) { Text("Admin Dashboard") }
    }
}
