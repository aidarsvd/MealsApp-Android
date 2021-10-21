package com.aidar.data.domain.meals.get_meal_detail

import com.aidar.data.data.meals.get_meal_detail.dto.MealListDetail

interface MealDetailRepository {
    suspend fun getMEalDetail(id: String): MealListDetail
}