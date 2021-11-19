package com.aidar.data.domain.meals.validate_meal

import io.reactivex.rxjava3.core.Single

interface ValidateMealRepository {
    fun validateMeal(id: String): Single<Boolean>
}