package com.aidar.data.data.meals.get_meal_categories.repository

import com.aidar.data.data.meals.get_meal_categories.api.CategoriesApi
import com.aidar.data.data.meals.get_meal_categories.dto.CategoryList
import com.aidar.data.domain.meals.get_meal_categories.MealCategoriesRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MealCategoriesRepositoryImpl @Inject constructor(private val api: CategoriesApi) : MealCategoriesRepository {
    override fun getMealCategories(): Observable<CategoryList> {
        return api.getCategories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    }
}