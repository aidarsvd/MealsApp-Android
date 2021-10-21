package com.aidar.data.data.meals.get_meal_categories.dto

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class CategoryList(
    @SerializedName("categories") var categories: ArrayList<Category>? = null
)