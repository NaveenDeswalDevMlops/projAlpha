package com.bebedirasoi.domain.repository

import com.bebedirasoi.data.model.Order
import kotlinx.coroutines.flow.Flow

interface OrderRepository {
    fun getOrdersForUser(userId: String): Flow<List<Order>>
    fun getAllOrders(): Flow<List<Order>>
    suspend fun placeOrder(order: Order): Result<String>
    suspend fun updateStatus(orderId: String, status: String): Result<Unit>
}
