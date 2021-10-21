package com.aidar.data.data.meals.delete_meal.repository

import com.aidar.data.base.model.Meal
import com.aidar.data.data.meals.delete_meal.dao.DeleteMealDao
import com.aidar.data.domain.delete_meal.DeleteMealRepository
import javax.inject.Inject

class DeleteMealRepositoryImpl @Inject constructor(
    private val deleteMealDao: DeleteMealDao
) : DeleteMealRepository {

    override suspend fun deleteMeal(meal: Meal) {
        deleteMealDao.delete(model = meal)
    }
}