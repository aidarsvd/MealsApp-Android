package com.aidar.data.domain.validate_meal

interface ValidateMealRepository {
    suspend fun validateMeal(id: String): Boolean
}