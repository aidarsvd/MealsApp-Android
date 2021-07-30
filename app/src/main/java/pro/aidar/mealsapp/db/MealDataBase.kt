package pro.aidar.mealsapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import pro.aidar.mealsapp.model.meal.Meal

@Database(entities = [Meal::class], version = 1)
abstract class MealDataBase: RoomDatabase() {
    abstract fun mealDao(): FavoritesDao
}