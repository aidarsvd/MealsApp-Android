package com.aidar.data.data.meals.get_favorites

import com.aidar.data.common.database.meals.MealDataBase
import com.aidar.data.data.meals.get_favorites.dao.GetFavoritesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object GetFavoritesModule {
    @Provides
    fun provideFavoriteMealsDao(db: MealDataBase): GetFavoritesDao {
        return db.getMeals()
    }
}