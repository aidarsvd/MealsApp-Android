package com.aidar.data.data.meals.validate_meal.dao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ValidateMealDao {
    @Query("SELECT EXISTS(SELECT * FROM meal_table WHERE idMeal = :name)")
    fun isRowIsExist(name: String): Boolean
}