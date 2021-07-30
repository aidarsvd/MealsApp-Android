package pro.aidar.mealsapp.model.meal

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meal_table")
data class Meal(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var strMeal: String? = null,
    var idMeal: String? = null,
    var strMealThumb: String? = null
)