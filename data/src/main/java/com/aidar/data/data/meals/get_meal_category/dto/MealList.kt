package com.aidar.data.data.meals.get_meal_category.dto

import com.aidar.data.base.model.Meal
import com.google.gson.annotations.SerializedName
import java.util.*

data class MealList(
    @SerializedName("meals")
    var meals: ArrayList<Meal>? = null
)