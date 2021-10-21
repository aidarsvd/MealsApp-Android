package com.aidar.data.domain.meals.get_favorites

import com.aidar.data.base.model.Meal

interface GetFavoriteRepository {
    suspend fun getFavorite(): List<Meal>
}