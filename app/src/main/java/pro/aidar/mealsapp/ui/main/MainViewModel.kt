package pro.aidar.mealsapp.ui.main

import androidx.lifecycle.viewModelScope
import com.aidar.data.base.model.Meal
import com.aidar.data.domain.add_meal.usecase.AddMealUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pro.aidar.mealsapp.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val addMealUseCase: AddMealUseCase
) : BaseViewModel() {

    fun likeMeal(meal: Meal) {
        viewModelScope.launch {
            addMealUseCase.execute(meal = meal)
        }
    }

}