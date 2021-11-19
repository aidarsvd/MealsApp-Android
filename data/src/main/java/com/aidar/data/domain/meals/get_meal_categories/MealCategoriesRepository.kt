package com.aidar.data.domain.meals.get_meal_categories

import com.aidar.data.data.meals.get_meal_categories.dto.CategoryList
import io.reactivex.rxjava3.core.Observable

interface MealCategoriesRepository {
    fun getMealCategories(): Observable<CategoryList>
}