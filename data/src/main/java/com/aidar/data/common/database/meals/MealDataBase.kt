package com.aidar.data.common.database.meals

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aidar.data.data.meals.add_meal.dao.AddMealDao
import com.aidar.data.base.model.Meal
import com.aidar.data.data.meals.delete_meal.dao.DeleteMealDao
import com.aidar.data.data.meals.get_favorites.dao.GetFavoritesDao
import com.aidar.data.data.meals.validate_meal.dao.ValidateMealDao

@Database(entities = [Meal::class], version = 1)
abstract class MealDataBase : RoomDatabase() {
    abstract fun addMeal(): AddMealDao
    abstract fun deleteMeal(): DeleteMealDao
    abstract fun getMeals(): GetFavoritesDao
    abstract fun validateMeal(): ValidateMealDao
}