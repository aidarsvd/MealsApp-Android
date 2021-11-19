package com.aidar.data.data.meals.validate_meal.repository

import com.aidar.data.data.meals.validate_meal.dao.ValidateMealDao
import com.aidar.data.domain.meals.validate_meal.ValidateMealRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ValidateMealRepositoryImpl @Inject constructor(private val validateMealDao: ValidateMealDao) :
    ValidateMealRepository {
    override fun validateMeal(id: String): Single<Boolean> {
        return Single.fromCallable { validateMealDao.isRowIsExist(name = id) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}