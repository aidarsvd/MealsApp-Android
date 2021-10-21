package com.aidar.data.data.meals.get_meal_categories.api

import com.aidar.data.data.meals.get_meal_categories.dto.CategoryList
import retrofit2.http.GET

interface CategoriesApi {
    @GET("api/json/v1/1/categories.php")
    suspend fun getCategories(): CategoryList
}