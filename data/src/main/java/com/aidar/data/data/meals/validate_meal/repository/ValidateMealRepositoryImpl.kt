package com.aidar.data.data.meals.validate_meal.repository

import com.aidar.data.data.meals.validate_meal.dao.ValidateMealDao
import com.aidar.data.domain.meals.validate_meal.ValidateMealRepository
import javax.inject.Inject

class ValidateMealRepositoryImpl @Inject constructor(private val validateMealDao: ValidateMealDao) :
    ValidateMealRepository {
    override suspend fun validateMeal(id: String): Boolean {
        return validateMealDao.isRowIsExist(name = id)
    }
}