package com.aidar.data.domain.meals.validate_meal

interface ValidateMealRepository {
    suspend fun validateMeal(id: String): Boolean
}