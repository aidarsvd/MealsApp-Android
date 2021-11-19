package com.aidar.data.data.meals.delete_meal.repository

import com.aidar.data.base.model.Meal
import com.aidar.data.data.meals.delete_meal.dao.DeleteMealDao
import com.aidar.data.domain.meals.delete_meal.DeleteMealRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class DeleteMealRepositoryImpl @Inject constructor(
    private val deleteMealDao: DeleteMealDao
) : DeleteMealRepository {

    override fun deleteMeal(meal: Meal): Completable {
        return Completable.fromAction { deleteMealDao.delete(model = meal) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}