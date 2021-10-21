package com.aidar.data.data.meals.get_meal_detail

import com.aidar.data.data.meals.get_meal_detail.api.MealDetailApi
import com.aidar.data.data.meals.get_meal_detail.repository.MealDetailRepositoryImpl
import com.aidar.data.domain.meals.get_meal_detail.MealDetailRepository
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

    @Singleton
    @Provides
    fun provideMealDetailRepository(api: MealDetailApi): MealDetailRepository {
        return MealDetailRepositoryImpl(api = api)
    }

}