package pro.aidar.mealsapp.ui.main.viewModel

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.internal.notify
import pro.aidar.mealsapp.base.BaseViewModel
import pro.aidar.mealsapp.model.category.CategoryList
import pro.aidar.mealsapp.model.meal.Meal
import pro.aidar.mealsapp.model.meal.MealList
import pro.aidar.mealsapp.model.meal.MealListDetail
import pro.aidar.mealsapp.model.status.LikeStatus
import pro.aidar.mealsapp.service.Repository

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : BaseViewModel() {

    val categories = MutableStateFlow(CategoryList())
    val meals = MutableStateFlow(MealList())
    private val _detailMeal = MutableStateFlow(MealListDetail())
    val detailMeal: StateFlow<MealListDetail> = _detailMeal.asStateFlow()

    val likedMeal = MutableStateFlow(listOf(Meal()))

    val likeStatus = MutableStateFlow(3)

    fun getCategories() {
        scope.launch {
            isLoad.set(true)
            try {
                val response = repository.getCategories()
                withContext(context = coroutineContext) {
                    categories.value = response
                }
                isLoad.set(false)
            } catch (e: Exception) {
                isLoad.set(false)
                e.stackTrace
            }
        }
    }

    fun getCategory(id: String) {
        scope.launch {
            isLoad.set(true)
            try {
                val response = repository.getCategory(category = id)
                withContext(context = coroutineContext) {
                    meals.value = response
                }
                isLoad.set(false)
            } catch (e: java.lang.Exception) {
                isLoad.set(false)
                e.stackTrace
            }
        }
    }

    fun getMealDetail(id: String) {
        scope.launch {
            isLoad.set(true)
            try {
                val response = repository.getMealId(mealId = id)
                withContext(context = coroutineContext) {
                    _detailMeal.value = response
                }
                isLoad.set(false)
            } catch (e: java.lang.Exception) {
                isLoad.set(false)
                e.stackTrace
            }
        }
    }

    private fun likeMeal(meal: Meal) {
        scope.launch {
            repository.like(meal)
        }
    }

    fun getFavorite() {
        scope.launch {
            val response = repository.getFavorites()
            withContext(context = coroutineContext) {
                likedMeal.value = response
            }
        }
    }

    fun validateLike(name: Meal) {
        scope.launch {
            try {
                val isExist = repository.isMealExists(name = name.idMeal!!)
                if (!isExist) {
                    likeMeal(meal = name)
                    likeStatus.value = LikeStatus.LIKED.value
                } else {
                    likeStatus.value = LikeStatus.EXIST.value
                    return@launch
                }
            } catch (e: Exception) {
                e.stackTrace
                likeStatus.value = LikeStatus.ERROR.value
                return@launch
            }
        }
    }

    fun deleteMealFromFavorite(meal: Meal) {
        scope.launch {
            try {
                repository.unLike(meal = meal)
            } catch (e: Exception) {
                e.stackTrace
            }
        }
    }
}