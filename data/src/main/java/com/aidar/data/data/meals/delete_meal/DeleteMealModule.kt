package com.aidar.data.data.meals.delete_meal

import com.aidar.data.common.database.meals.MealDataBase
import com.aidar.data.data.meals.delete_meal.dao.DeleteMealDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DeleteMealModule {
    @Provides
    fun provideDeleteMealDao(db: MealDataBase): DeleteMealDao {
        return db.deleteMeal()
    }
}