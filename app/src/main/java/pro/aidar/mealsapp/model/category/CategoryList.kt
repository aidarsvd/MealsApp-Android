package pro.aidar.mealsapp.model.category

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class CategoryList(
    @SerializedName("categories") var categories: ArrayList<Category>? = null
)