package com.aidar.data.data.meals.get_meal_categories

import com.aidar.data.data.meals.get_meal_categories.api.CategoriesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CategoriesModule {

    @Singleton
    @Provides
    fun provideCategoriesApi(retrofit: Retrofit): CategoriesApi {
        return retrofit.create(CategoriesApi::class.java)
    }

}