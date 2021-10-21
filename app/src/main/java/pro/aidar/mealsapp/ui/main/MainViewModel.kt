package pro.aidar.mealsapp.ui.main

import androidx.lifecycle.viewModelScope
import com.aidar.data.base.model.Meal
import com.aidar.data.domain.meals.add_meal.usecase.AddMealUseCase
import com.aidar.data.domain.meals.get_meal_categories.usecase.MealCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pro.aidar.mealsapp.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val addMealUseCase: AddMealUseCase,
    private val categoriesUseCase: MealCategoriesUseCase
) : BaseViewModel() {

    fun likeMeal(meal: Meal) {
        viewModelScope.launch {
            addMealUseCase.execute(meal = meal)
        }
    }

    fun fetchCategories() {
        viewModelScope.launch {
            categoriesUseCase.execute()
        }
    }

}