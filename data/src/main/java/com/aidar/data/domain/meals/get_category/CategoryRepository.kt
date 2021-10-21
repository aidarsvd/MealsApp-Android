package com.aidar.data.domain.meals.get_category

import com.aidar.data.data.meals.get_meal_category.dto.MealList

interface CategoryRepository {
    suspend fun getCategory(name: String): MealList
}