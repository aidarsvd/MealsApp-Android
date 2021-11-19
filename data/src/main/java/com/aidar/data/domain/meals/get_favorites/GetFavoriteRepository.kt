package com.aidar.data.domain.meals.get_favorites

import com.aidar.data.base.model.Meal
import io.reactivex.rxjava3.core.Observable

interface GetFavoriteRepository {
    fun getFavorite(): Observable<List<Meal>>
}