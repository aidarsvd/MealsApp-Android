package com.aidar.data.domain.meals.get_meal_categories.usecase

import com.aidar.data.data.meals.get_meal_categories.dto.CategoryList
import com.aidar.data.domain.meals.get_meal_categories.MealCategoriesRepository
import javax.inject.Inject

class MealCategoriesUseCase @Inject constructor(private val categoriesRepository: MealCategoriesRepository) {
    suspend fun execute(): CategoryList {
        return categoriesRepository.getMealCategories()
    }
}