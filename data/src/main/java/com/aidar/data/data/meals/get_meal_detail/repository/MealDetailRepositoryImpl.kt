package com.aidar.data.data.meals.get_meal_detail.repository

import com.aidar.data.data.meals.get_meal_detail.api.MealDetailApi
import com.aidar.data.data.meals.get_meal_detail.dto.MealListDetail
import com.aidar.data.domain.meals.get_meal_detail.MealDetailRepository
import javax.inject.Inject

class MealDetailRepositoryImpl @Inject constructor(private val api: MealDetailApi) : MealDetailRepository {
    override suspend fun getMEalDetail(id: String): MealListDetail {
        return api.getMealDetail(i = id)
    }
}