package com.aidar.data.data.meals.validate_meal

import com.aidar.data.common.database.meals.MealDataBase
import com.aidar.data.data.meals.validate_meal.dao.ValidateMealDao
import com.aidar.data.data.meals.validate_meal.repository.ValidateMealRepositoryImpl
import com.aidar.data.domain.validate_meal.ValidateMealRepository
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

    @Provides
    fun provideValidateRepository(validateMealDao: ValidateMealDao): ValidateMealRepository {
        return ValidateMealRepositoryImpl(validateMealDao = validateMealDao)
    }
}