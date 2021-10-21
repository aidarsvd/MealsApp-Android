package com.aidar.data.domain.add_meal

import com.aidar.data.base.model.Meal

interface AddMealRepository {
    fun addMeal(meal: Meal)
}