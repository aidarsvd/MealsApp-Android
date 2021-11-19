package com.aidar.data.domain.meals.get_category.usecase

import com.aidar.data.data.meals.get_meal_category.dto.MealList
import com.aidar.data.domain.meals.get_category.CategoryRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class MealCategoryUseCase @Inject constructor(private val repository: CategoryRepository) {
    fun execute(name: String): Observable<MealList> {
        return repository.getCategory(name = name)
    }
}