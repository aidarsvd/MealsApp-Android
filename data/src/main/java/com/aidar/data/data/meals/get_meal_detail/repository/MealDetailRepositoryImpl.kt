package com.aidar.data.data.meals.get_meal_detail.repository

import com.aidar.data.data.meals.get_meal_detail.api.MealDetailApi
import com.aidar.data.data.meals.get_meal_detail.dto.MealListDetail
import com.aidar.data.domain.meals.get_meal_detail.MealDetailRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MealDetailRepositoryImpl @Inject constructor(private val api: MealDetailApi) : MealDetailRepository {
    override fun getMEalDetail(id: String): Observable<MealListDetail> {
        return api.getMealDetail(i = id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}