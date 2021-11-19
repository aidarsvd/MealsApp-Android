package com.aidar.data.domain.meals.get_favorites.usecase

import com.aidar.data.base.model.Meal
import com.aidar.data.domain.meals.get_favorites.GetFavoriteRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class FavoriteMealsUseCase @Inject constructor(private val getFavoriteRepository: GetFavoriteRepository) {

    fun getFavorites(): Observable<List<Meal>> {
        return getFavoriteRepository.getFavorite()
    }

}