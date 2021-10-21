package com.aidar.data.domain.get_favorites

import com.aidar.data.base.model.Meal

interface GetFavoriteRepository {
    suspend fun getFavorite(): List<Meal>
}