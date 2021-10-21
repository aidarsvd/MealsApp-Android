package com.aidar.data.data.meals.get_favorites.dao

import androidx.room.Dao
import androidx.room.Query
import com.aidar.data.base.model.Meal

@Dao
interface GetFavoritesDao {
    @Query("select * from meal_table order by id asc")
    fun getFavorites(): List<Meal>
}