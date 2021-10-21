package com.aidar.data.data.meals.get_meal_categories.repository

import com.aidar.data.data.meals.get_meal_categories.api.CategoriesApi
import com.aidar.data.data.meals.get_meal_categories.dto.CategoryList
import com.aidar.data.domain.meals.get_meal_categories.MealCategoriesRepository
import javax.inject.Inject

class MealCategoriesRepositoryImpl @Inject constructor(private val api: CategoriesApi) : MealCategoriesRepository {
    override suspend fun getMealCategories(): CategoryList {
        return api.getCategories()
    }
}