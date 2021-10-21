package com.aidar.data.domain.get_favorites.usecase

import com.aidar.data.base.model.Meal
import com.aidar.data.domain.get_favorites.GetFavoriteRepository
import javax.inject.Inject

class FavoriteMealsUseCase @Inject constructor(private val getFavoriteRepository: GetFavoriteRepository) {

    suspend fun getFavorites(): List<Meal> {
        return getFavoriteRepository.getFavorite()
    }

}