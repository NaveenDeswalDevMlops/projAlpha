package com.bebedirasoi.domain.repository

import com.bebedirasoi.data.model.Meal
import kotlinx.coroutines.flow.Flow

interface MealRepository {
    fun getMeals(): Flow<List<Meal>>
    suspend fun upsertMeal(meal: Meal): Result<Unit>
    suspend fun deleteMeal(mealId: String): Result<Unit>
}
