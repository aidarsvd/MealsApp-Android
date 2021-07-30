package pro.aidar.mealsapp.model.meal

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class MealListDetail(
    @SerializedName("meals")
    var meals: ArrayList<MealDetail>? = null
)