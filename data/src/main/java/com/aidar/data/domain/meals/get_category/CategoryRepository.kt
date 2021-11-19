package com.aidar.data.domain.meals.get_category

import com.aidar.data.data.meals.get_meal_category.dto.MealList
import io.reactivex.rxjava3.core.Observable

interface CategoryRepository {
    fun getCategory(name: String): Observable<MealList>
}