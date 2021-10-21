package com.aidar.data.data.meals.add_meal.repository

import com.aidar.data.base.model.Meal
import com.aidar.data.data.meals.add_meal.dao.AddMealDao
import com.aidar.data.domain.add_meal.AddMealRepository
import javax.inject.Inject

class AddMealRepositoryImpl @Inject constructor(
    private val addMealDao: AddMealDao
) : AddMealRepository {

    override fun addMeal(meal: Meal) {

    }
}