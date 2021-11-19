package com.aidar.data.domain.meals.get_meal_detail

import com.aidar.data.data.meals.get_meal_detail.dto.MealListDetail
import io.reactivex.rxjava3.core.Observable

interface MealDetailRepository {
    fun getMEalDetail(id: String): Observable<MealListDetail>
}