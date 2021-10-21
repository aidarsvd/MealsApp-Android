package com.aidar.data.data.meals.get_meal_categories.dto

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("idCategory") var idCategory: String,
    @SerializedName("strCategory") var strCategory: String,
    @SerializedName("strCategoryThumb") var strCategoryThumb: String
)