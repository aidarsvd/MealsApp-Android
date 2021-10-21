package com.aidar.data.domain.meals.validate_meal.usecase

import com.aidar.data.domain.meals.validate_meal.ValidateMealRepository
import javax.inject.Inject

class ValidateMealUseCase @Inject constructor(private val repository: ValidateMealRepository) {
    suspend fun execute(id: String): Boolean {
        return repository.validateMeal(id = id)
    }
}