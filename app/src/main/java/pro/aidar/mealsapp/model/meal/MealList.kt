package pro.aidar.mealsapp.model.meal

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class MealList(
    @SerializedName("meals")
    var meals: ArrayList<Meal>? = null
)