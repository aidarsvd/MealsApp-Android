package com.aidar.data.domain.meals.validate_meal.usecase

import com.aidar.data.domain.meals.validate_meal.ValidateMealRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ValidateMealUseCase @Inject constructor(private val repository: ValidateMealRepository) {
    fun execute(id: String): Single<Boolean> {
        return repository.validateMeal(id = id)
    }
}