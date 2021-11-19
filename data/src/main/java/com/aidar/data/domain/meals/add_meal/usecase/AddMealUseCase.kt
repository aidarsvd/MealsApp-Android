package com.aidar.data.domain.meals.add_meal.usecase

import com.aidar.data.base.model.Meal
import com.aidar.data.domain.meals.add_meal.AddMealRepository
import io.reactivex.rxjava3.core.Completable
import javax.inject.Inject

class AddMealUseCase @Inject constructor(private val addMealRepository: AddMealRepository) {
    fun execute(meal: Meal): Completable {
        return addMealRepository.addMeal(meal = meal)
    }
}