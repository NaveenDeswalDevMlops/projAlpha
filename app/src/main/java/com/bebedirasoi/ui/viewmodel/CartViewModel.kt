package com.bebedirasoi.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.bebedirasoi.data.model.CartItem
import com.bebedirasoi.data.model.Meal
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class CartViewModel @Inject constructor() : ViewModel() {
    private val _cart = MutableStateFlow<List<CartItem>>(emptyList())
    val cart: StateFlow<List<CartItem>> = _cart.asStateFlow()

    fun addItem(meal: Meal) {
        _cart.update { current ->
            val existing = current.find { it.meal.id == meal.id }
            if (existing == null) current + CartItem(meal = meal)
            else current.map { if (it.meal.id == meal.id) it.copy(quantity = it.quantity + 1) else it }
        }
    }

    fun clear() = _cart.update { emptyList() }
    fun totalAmount(): Double = _cart.value.sumOf { it.meal.price * it.quantity }
}
