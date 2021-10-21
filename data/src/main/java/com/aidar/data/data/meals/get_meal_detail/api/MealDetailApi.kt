package com.aidar.data.data.meals.get_meal_detail.api

import com.aidar.data.data.meals.get_meal_detail.dto.MealListDetail
import retrofit2.http.GET
import retrofit2.http.Query


interface MealDetailApi {
    @GET("api/json/v1/1/lookup.php")
    suspend fun getMealDetail(@Query("i") i: String): MealListDetail
}