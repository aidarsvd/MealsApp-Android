package com.aidar.data.data.meals.get_meal_categories.api

import com.aidar.data.data.meals.get_meal_categories.dto.CategoryList
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface CategoriesApi {
    @GET("api/json/v1/1/categories.php")
    fun getCategories(): Observable<CategoryList>
}