package com.aidar.data.common.database.meals

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object MealsDataBaseModule {

    @Provides
    @Singleton
    fun provideMealsDatabase(
        @ApplicationContext context: Context
    ): MealDataBase {
        return Room.databaseBuilder(
            context,
            MealDataBase::class.java,
            "database"
        ).allowMainThreadQueries()
            .build()
    }

}