package com.aidar.data.domain.meals.add_meal.usecase

import com.aidar.data.base.model.Meal
import com.aidar.data.domain.meals.add_meal.AddMealRepository
import javax.inject.Inject

class AddMealUseCase @Inject constructor(private val addMealRepository: AddMealRepository) {
    suspend fun execute(meal: Meal) {
        addMealRepository.addMeal(meal = meal)
    }
}