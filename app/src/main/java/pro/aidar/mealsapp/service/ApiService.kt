package pro.aidar.mealsapp.service

import pro.aidar.mealsapp.model.category.CategoryList
import pro.aidar.mealsapp.model.meal.MealList
import pro.aidar.mealsapp.model.meal.MealListDetail
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/json/v1/1/categories.php")
    suspend fun getCategories(): CategoryList

    @GET("api/json/v1/1/filter.php?")
    suspend fun getCategory(@Query("c") c: String): MealList

    @GET("api/json/v1/1/lookup.php")
    suspend fun getMealDetail(@Query("i") i: String): MealListDetail
}