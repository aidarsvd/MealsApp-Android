package com.aidar.data.data.meals.validate_meal

import com.aidar.data.common.database.meals.MealDataBase
import com.aidar.data.data.meals.validate_meal.dao.ValidateMealDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object ValidateMealModule {
    @Provides
    fun provideValidateMealDao(db: MealDataBase): ValidateMealDao {
        return db.validateMeal()
    }
}