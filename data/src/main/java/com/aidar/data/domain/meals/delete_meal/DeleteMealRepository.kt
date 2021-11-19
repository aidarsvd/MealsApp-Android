package com.aidar.data.domain.meals.delete_meal

import com.aidar.data.base.model.Meal
import io.reactivex.rxjava3.core.Completable

interface DeleteMealRepository {
    fun deleteMeal(meal: Meal): Completable
}