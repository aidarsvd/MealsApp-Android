package com.aidar.data.domain.delete_meal.usecase

import com.aidar.data.base.model.Meal
import com.aidar.data.domain.delete_meal.DeleteMealRepository
import javax.inject.Inject

class DeleteMealUseCase @Inject constructor(private val repository: DeleteMealRepository) {
    suspend fun execute(meal: Meal) {
        repository.deleteMeal(meal = meal)
    }
}