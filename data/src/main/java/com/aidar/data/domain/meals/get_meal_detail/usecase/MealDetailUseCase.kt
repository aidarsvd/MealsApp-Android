package com.aidar.data.domain.meals.get_meal_detail.usecase

import com.aidar.data.data.meals.get_meal_detail.dto.MealListDetail
import com.aidar.data.domain.meals.get_meal_detail.MealDetailRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class MealDetailUseCase @Inject constructor(private val repository: MealDetailRepository) {
    fun execute(id: String): Observable<MealListDetail> {
        return repository.getMEalDetail(id = id)
    }
}