package com.aidar.data.domain.meals.get_meal_categories

import com.aidar.data.data.meals.get_meal_categories.dto.CategoryList

interface MealCategoriesRepository {
    suspend fun getMealCategories(): CategoryList
}