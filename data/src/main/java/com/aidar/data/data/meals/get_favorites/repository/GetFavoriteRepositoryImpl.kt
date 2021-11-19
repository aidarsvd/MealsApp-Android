package com.aidar.data.data.meals.get_favorites.repository

import com.aidar.data.base.model.Meal
import com.aidar.data.data.meals.get_favorites.dao.GetFavoritesDao
import com.aidar.data.domain.meals.get_favorites.GetFavoriteRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class GetFavoriteRepositoryImpl @Inject constructor(private val getFavoritesDao: GetFavoritesDao) :
    GetFavoriteRepository {
    override fun getFavorite(): Observable<List<Meal>> {
        return Observable.fromCallable { getFavoritesDao.getFavorites() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}