package pro.aidar.mealsapp.service

import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import pro.aidar.mealsapp.db.FavoritesDao
import pro.aidar.mealsapp.model.category.CategoryList
import pro.aidar.mealsapp.model.meal.Meal
import pro.aidar.mealsapp.model.meal.MealList
import pro.aidar.mealsapp.model.meal.MealListDetail
import retrofit2.Response

@Singleton
class Repository @Inject constructor(
    private val apiService: ApiService,
    private val favoritesDao: FavoritesDao
) {
    suspend fun getCategories(): CategoryList {
        return apiService.getCategories()
    }

    suspend fun getCategory(category: String): MealList {
        return apiService.getCategory(c = category)
    }

    suspend fun getMealId(mealId: String): MealListDetail {
        return apiService.getMealDetail(i = mealId)
    }

    fun getFavorites(): List<Meal> {
        return favoritesDao.getFavorites()
    }

    suspend fun like(meal: Meal) {
        favoritesDao.addMeal(meal = meal)
    }

    fun unLike(meal: Meal) {
        favoritesDao.delete(model = meal)
    }

    fun isMealExists(name: String): Boolean {
        return favoritesDao.isRowIsExist(name = name)
    }

    suspend fun getRandom(): MealListDetail {
        return apiService.getRandom()
    }
}