package com.aidar.data.domain.meals.get_meal_categories.usecase

import com.aidar.data.data.meals.get_meal_categories.dto.CategoryList
import com.aidar.data.domain.meals.get_meal_categories.MealCategoriesRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class MealCategoriesUseCase @Inject constructor(private val categoriesRepository: MealCategoriesRepository) {
    fun execute(): Observable<CategoryList> {
        return categoriesRepository.getMealCategories()
    }
}