package com.bebedirasoi.data.model

data class UserProfile(
    val id: String = "",
    val name: String = "",
    val email: String = "",
    val role: String = "customer",
    val phone: String = "",
    val addresses: List<String> = emptyList()
)

data class Meal(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val imageUrl: String = "",
    val ingredients: List<String> = emptyList(),
    val calories: Int = 0,
    val price: Double = 0.0,
    val rating: Double = 0.0,
    val categoryId: String = "",
    val isAvailable: Boolean = true
)

data class CartItem(
    val meal: Meal,
    val quantity: Int = 1
)

data class Order(
    val id: String = "",
    val userId: String = "",
    val items: List<CartItem> = emptyList(),
    val deliverySlot: String = "",
    val status: String = "Preparing",
    val totalAmount: Double = 0.0,
    val paymentId: String = "",
    val createdAt: Long = System.currentTimeMillis()
)
