package com.aidar.data.data.meals.get_favorites.repository

import com.aidar.data.base.model.Meal
import com.aidar.data.data.meals.get_favorites.dao.GetFavoritesDao
import com.aidar.data.domain.meals.get_favorites.GetFavoriteRepository
import javax.inject.Inject

class GetFavoriteRepositoryImpl @Inject constructor(private val getFavoritesDao: GetFavoritesDao) :
    GetFavoriteRepository {
    override suspend fun getFavorite(): List<Meal> {
        return getFavoritesDao.getFavorites()
    }
}