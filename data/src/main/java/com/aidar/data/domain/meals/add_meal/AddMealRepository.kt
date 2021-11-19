package com.aidar.data.domain.meals.add_meal

import com.aidar.data.base.model.Meal
import io.reactivex.rxjava3.core.Completable

interface AddMealRepository {
    fun addMeal(meal: Meal): Completable
}