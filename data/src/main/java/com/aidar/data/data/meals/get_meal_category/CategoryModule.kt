package com.aidar.data.data.meals.get_meal_category

import com.aidar.data.data.meals.get_meal_category.api.MealCategoryApi
import com.aidar.data.data.meals.get_meal_category.repository.CategoryRepositoryImpl
import com.aidar.data.domain.meals.get_category.CategoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CategoryModule {

    @Singleton
    @Provides
    fun provideCategoryApi(retrofit: Retrofit): MealCategoryApi {
        return retrofit.create(MealCategoryApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(api: MealCategoryApi): CategoryRepository {
        return CategoryRepositoryImpl(api = api)
    }

}