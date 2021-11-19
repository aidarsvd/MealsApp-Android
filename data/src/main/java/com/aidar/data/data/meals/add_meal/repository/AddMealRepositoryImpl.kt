package com.aidar.data.data.meals.add_meal.repository

import com.aidar.data.base.model.Meal
import com.aidar.data.data.meals.add_meal.dao.AddMealDao
import com.aidar.data.domain.meals.add_meal.AddMealRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class AddMealRepositoryImpl @Inject constructor(
    private val addMealDao: AddMealDao
) : AddMealRepository {

    override fun addMeal(meal: Meal): Completable {
        return Completable.fromAction { addMealDao.addMeal(meal = meal) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}