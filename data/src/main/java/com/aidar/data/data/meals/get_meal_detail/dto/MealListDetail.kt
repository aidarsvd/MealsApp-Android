package com.aidar.data.data.meals.get_meal_detail.dto

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class MealListDetail(
    @SerializedName("meals")
    var meals: ArrayList<MealDetail>? = null
)