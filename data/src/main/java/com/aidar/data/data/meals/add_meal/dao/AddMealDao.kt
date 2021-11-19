package com.aidar.data.data.meals.add_meal.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.aidar.data.base.model.Meal

@Dao
interface AddMealDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMeal(meal: Meal)
}