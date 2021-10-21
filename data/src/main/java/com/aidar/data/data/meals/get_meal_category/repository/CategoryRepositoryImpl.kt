package com.aidar.data.data.meals.get_meal_category.repository

import com.aidar.data.data.meals.get_meal_category.api.MealCategoryApi
import com.aidar.data.data.meals.get_meal_category.dto.MealList
import com.aidar.data.domain.meals.get_category.CategoryRepository
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(private val api: MealCategoryApi) : CategoryRepository {
    override suspend fun getCategory(name: String): MealList {
        return api.getCategory(c = name)
    }
}