package pro.aidar.mealsapp.ui.main.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aidar.data.base.model.Meal
import com.aidar.data.data.meals.get_meal_categories.dto.CategoryList
import com.aidar.data.data.meals.get_meal_category.dto.MealList
import com.aidar.data.data.meals.get_meal_detail.dto.MealListDetail
import com.aidar.data.domain.meals.add_meal.usecase.AddMealUseCase
import com.aidar.data.domain.meals.delete_meal.usecase.DeleteMealUseCase
import com.aidar.data.domain.meals.get_category.usecase.MealCategoryUseCase
import com.aidar.data.domain.meals.get_favorites.usecase.FavoriteMealsUseCase
import com.aidar.data.domain.meals.get_meal_categories.usecase.MealCategoriesUseCase
import com.aidar.data.domain.meals.get_meal_detail.usecase.MealDetailUseCase
import com.aidar.data.domain.meals.validate_meal.usecase.ValidateMealUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pro.aidar.mealsapp.base.BaseViewModel
import pro.aidar.mealsapp.utils.status.LikeStatus
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val categoriesUseCase: MealCategoriesUseCase,
    private val categoryUseCase: MealCategoryUseCase,
    private val mealDetailUseCase: MealDetailUseCase,
    private val addMealUseCase: AddMealUseCase,
    private val deleteMealUseCase: DeleteMealUseCase,
    private val validateMealUseCase: ValidateMealUseCase,
    private val favoriteMealsUseCase: FavoriteMealsUseCase

) : BaseViewModel() {

    val likeStatus = MutableLiveData(LikeStatus.LIKED)

    val categories: MutableLiveData<CategoryList> by lazy {
        MutableLiveData(CategoryList())
    }

    val category: MutableLiveData<MealList> by lazy {
        MutableLiveData(MealList())
    }

    val mealDetail: MutableLiveData<MealListDetail> by lazy {
        MutableLiveData(MealListDetail())
    }

    val favorites: MutableLiveData<List<Meal>> by lazy {
        MutableLiveData(listOf())
    }

    fun fetchCategories() {
        isLoad.set(true)
        viewModelScope.launch {
            withContext(coroutineContext) {
                categories.postValue(categoriesUseCase.execute())
                isLoad.set(false)
            }
        }
    }

    fun fetchCategory(id: String) {
        viewModelScope.launch {
            withContext(coroutineContext) {
                category.postValue(categoryUseCase.execute(name = id))
            }
        }
    }

    fun fetchFavorite() {
        viewModelScope.launch {
            withContext(coroutineContext) {
                favorites.postValue(favoriteMealsUseCase.getFavorites())
            }
        }
    }

    fun fetchDetailMeal(id: String) {
        viewModelScope.launch {
            withContext(coroutineContext) {
                mealDetail.postValue(mealDetailUseCase.execute(id = id))
            }
        }
    }

    fun validateMeal(name: Meal) {
        viewModelScope.launch {
            try {
                val isExist = validateMealUseCase.execute(id = name.idMeal!!)
                if (!isExist) {
                    addMealUseCase.execute(meal = name)
                    likeStatus.value = LikeStatus.LIKED
                } else {
                    likeStatus.value = LikeStatus.EXIST
                    return@launch
                }
            } catch (e: Exception) {
                e.stackTrace
                likeStatus.value = LikeStatus.ERROR
                return@launch
            }
        }
    }

    fun deleteMealFromFavorite(meal: Meal) {
        viewModelScope.launch {
            deleteMealUseCase.execute(meal = meal)
        }
    }

}