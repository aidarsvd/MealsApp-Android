package com.aidar.data.data.meals.get_meal_category.repository

import com.aidar.data.data.meals.get_meal_category.api.MealCategoryApi
import com.aidar.data.data.meals.get_meal_category.dto.MealList
import com.aidar.data.domain.meals.get_category.CategoryRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(private val api: MealCategoryApi) : CategoryRepository {
    override fun getCategory(name: String): Observable<MealList> {
        return api.getCategory(c = name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}