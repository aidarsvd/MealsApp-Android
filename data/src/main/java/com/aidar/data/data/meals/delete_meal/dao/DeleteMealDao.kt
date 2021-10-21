package com.aidar.data.data.meals.delete_meal.dao

import androidx.room.Dao
import androidx.room.Delete
import com.aidar.data.base.model.Meal

@Dao
interface DeleteMealDao {
    @Delete
    fun delete(model: Meal)
}