package com.aidar.data.data.meals.get_meal_detail

import com.aidar.data.data.meals.get_meal_detail.api.MealDetailApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object MealDetailModule {

    @Singleton
    @Provides
    fun provideMealDetailApi(retrofit: Retrofit): MealDetailApi {
        return retrofit.create(MealDetailApi::class.java)
    }

}