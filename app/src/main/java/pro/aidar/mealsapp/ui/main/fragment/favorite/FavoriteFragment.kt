package pro.aidar.mealsapp.ui.main.fragment.favorite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import java.util.ArrayList
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import pro.aidar.mealsapp.R
import pro.aidar.mealsapp.base.BaseFragment
import pro.aidar.mealsapp.databinding.FragmentFavoriteBinding
import pro.aidar.mealsapp.model.meal.Meal
import pro.aidar.mealsapp.ui.main.adapter.MealsAdapter
import pro.aidar.mealsapp.ui.main.viewModel.MainViewModel
import pro.aidar.mealsapp.utils.AppConstant
import pro.aidar.mealsapp.utils.AppConstant.DETAIL_VIEW_MODE
import pro.aidar.mealsapp.utils.AppConstant.MEAL_PRIMARY_KEY
import pro.aidar.mealsapp.utils.AppConstant.VIEW_DETAIL_FROM_FAV
import pro.aidar.mealsapp.utils.displayPopUp

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>(
    R.layout.fragment_favorite
), MealsAdapter.MealListener {
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var adapter: MealsAdapter
    private var meals = ArrayList<Meal>()
    override fun setUpView() {
        initAdapter()
        getLiked()
        initObservers()
    }

    private fun getLiked() {
        viewModel.getFavorite()
    }

    private fun initObservers() {
        lifecycleScope.launchWhenCreated {
            viewModel.likedMeal.collect { data ->
                meals.clear()
                data.map { meals.add(it) }
                adapter.notifyDataSetChanged()
            }
        }
    }

    private fun initAdapter() {
        lifecycleScope.launch {
            adapter = MealsAdapter(list = meals, listener = this@FavoriteFragment)
            binding.favoritesRecycler.adapter = adapter
        }
    }

    override fun onMealClick(model: Meal) {
        val bundle = Bundle()
        bundle.putString(AppConstant.MEAL_ID, model.idMeal)
        bundle.putString(DETAIL_VIEW_MODE, VIEW_DETAIL_FROM_FAV)
        bundle.putInt(MEAL_PRIMARY_KEY, model.id!!)
        findNavController().navigate(R.id.action_favoriteFragment_to_mealDetailFragment, bundle)
    }

    override fun onOptionsMenuClick(model: Meal, view: View, position: Int) {
        displayPopUp(view = view, menu = R.menu.meal_favorite_menu, itemId = R.id.unlike_meal) {
            viewModel.deleteMealFromFavorite(meal = model)
            adapter.removeItem(model = model, position = position)
        }
    }
}