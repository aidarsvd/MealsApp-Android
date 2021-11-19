package com.aidar.data.domain.meals.delete_meal.usecase

import com.aidar.data.base.model.Meal
import com.aidar.data.domain.meals.delete_meal.DeleteMealRepository
import io.reactivex.rxjava3.core.Completable
import javax.inject.Inject

class DeleteMealUseCase @Inject constructor(private val repository: DeleteMealRepository) {
    fun execute(meal: Meal): Completable {
        return repository.deleteMeal(meal = meal)
    }
}