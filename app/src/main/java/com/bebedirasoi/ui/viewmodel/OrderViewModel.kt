package com.bebedirasoi.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bebedirasoi.data.model.Order
import com.bebedirasoi.domain.repository.OrderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val orderRepository: OrderRepository
) : ViewModel() {
    private val _orders = MutableStateFlow<List<Order>>(emptyList())
    val orders: StateFlow<List<Order>> = _orders.asStateFlow()

    fun observeUserOrders(userId: String) = viewModelScope.launch {
        orderRepository.getOrdersForUser(userId).collect { _orders.value = it }
    }

    fun updateOrderStatus(orderId: String, status: String) = viewModelScope.launch {
        orderRepository.updateStatus(orderId, status)
    }
}
