package com.aidar.data.domain.meals.get_meal_detail.usecase

import com.aidar.data.data.meals.get_meal_detail.dto.MealListDetail
import com.aidar.data.domain.meals.get_meal_detail.MealDetailRepository
import javax.inject.Inject

class MealDetailUseCase @Inject constructor(private val repository: MealDetailRepository) {
    suspend fun execute(id: String): MealListDetail {
        return repository.getMEalDetail(id = id)
    }
}