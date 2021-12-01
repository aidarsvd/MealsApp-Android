package pro.aidar.mealsapp.ui.main.viewModel

import androidx.lifecycle.MutableLiveData
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
import javax.inject.Inject
import pro.aidar.mealsapp.base.BaseViewModel
import pro.aidar.mealsapp.base.SingleLiveEvent
import pro.aidar.mealsapp.utils.status.LikeStatus

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

    val categories = SingleLiveEvent<CategoryList>()

    val category = SingleLiveEvent<MealList>()

    val mealDetail = SingleLiveEvent<MealListDetail>()

    val favorites = SingleLiveEvent<List<Meal>>()

    fun fetchCategories() {
        disposable.add(
            categoriesUseCase.execute()
                .doOnSubscribe { isLoad.set(true) }
                .doOnTerminate { isLoad.set(false) }
                .subscribe({
                    categories.postValue(it)
                }, ::handleError)
        )
    }

    fun fetchCategory(id: String) {
        disposable.add(
            categoryUseCase.execute(name = id)
                .doOnSubscribe { isLoad.set(true) }
                .doOnTerminate { isLoad.set(false) }
                .subscribe({
                    category.postValue(it)
                    isLoad.set(false)
                }, ::handleError)
        )
    }

    fun fetchFavorite() {
        disposable.add(
            favoriteMealsUseCase.getFavorites()
                .doOnSubscribe { isLoad.set(true) }
                .doOnTerminate { isLoad.set(false) }
                .subscribe({
                    favorites.postValue(it)
                }, ::handleError)
        )
    }

    fun fetchDetailMeal(id: String) {
        disposable.add(
            mealDetailUseCase.execute(id = id)
                .doOnSubscribe { isLoad.set(true) }
                .doOnTerminate { isLoad.set(false) }
                .subscribe({
                    mealDetail.postValue(it)
                }, ::handleError)
        )
    }

    fun validateMeal(meal: Meal) {
        disposable.add(
            validateMealUseCase.execute(meal.idMeal!!)
                .subscribe({
                    if (it) likeStatus.postValue(LikeStatus.EXIST)
                    else {
                        addMealUseCase.execute(meal).subscribe({
                            likeStatus.postValue(LikeStatus.LIKED)
                        }, {
                            likeStatus.postValue(LikeStatus.ERROR)
                        })
                    }
                }, ::handleError)
        )
    }

    fun deleteMealFromFavorite(meal: Meal) {
        disposable.add(
            deleteMealUseCase.execute(meal).subscribe()
        )
    }
}