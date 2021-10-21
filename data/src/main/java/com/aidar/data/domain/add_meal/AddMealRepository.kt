package com.aidar.data.domain.add_meal

import com.aidar.data.base.model.Meal

interface AddMealRepository {
    suspend fun addMeal(meal: Meal)
}