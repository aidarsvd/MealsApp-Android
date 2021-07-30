package pro.aidar.mealsapp.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import java.util.ArrayList
import pro.aidar.mealsapp.model.meal.Meal

@Dao
interface FavoritesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMeal(meal: Meal)

    @Query("select * from meal_table order by id asc")
    fun getFavorites(): List<Meal>

    @Delete
    fun delete(model: Meal)

    @Query("SELECT EXISTS(SELECT * FROM meal_table WHERE idMeal = :name)")
    fun isRowIsExist(name: String): Boolean
}