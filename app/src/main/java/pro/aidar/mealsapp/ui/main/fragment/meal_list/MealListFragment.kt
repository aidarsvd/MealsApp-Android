package pro.aidar.mealsapp.ui.main.fragment.meal_list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.aidar.data.base.model.Meal
import kotlinx.coroutines.launch
import pro.aidar.mealsapp.R
import pro.aidar.mealsapp.base.BaseFragment
import pro.aidar.mealsapp.databinding.FragmentMealListBinding
import pro.aidar.mealsapp.ui.main.adapter.MealsAdapter
import pro.aidar.mealsapp.ui.main.viewModel.MainViewModel
import pro.aidar.mealsapp.utils.AppConstant.CATEGORY_ID
import pro.aidar.mealsapp.utils.AppConstant.DETAIL_VIEW_MODE
import pro.aidar.mealsapp.utils.AppConstant.MEAL_ID
import pro.aidar.mealsapp.utils.AppConstant.VIEW_DETAIL_FROM_LIST
import pro.aidar.mealsapp.utils.displayPopUp
import pro.aidar.mealsapp.utils.showToast
import pro.aidar.mealsapp.utils.status.LikeStatus
import java.util.*

class MealListFragment : BaseFragment<FragmentMealListBinding>(R.layout.fragment_meal_list), MealsAdapter.MealListener {
    private lateinit var mealId: String
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var adapter: MealsAdapter
    private var meals = ArrayList<Meal>()
    override fun setUpView() {
        binding.viewModel = viewModel
        initAdapter()
        setUpObservers()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initMealId()
    }
    private fun getMealDetail() {
        viewModel.fetchCategory(id = mealId)
    }

    private fun initMealId() {
        arguments.let {
            mealId = it!!.getString(CATEGORY_ID)!!
            getMealDetail()
        }
    }

    private fun initAdapter() {
        lifecycleScope.launch {
            adapter = MealsAdapter(list = meals, listener = this@MealListFragment)
            binding.mealsRecycler.adapter = adapter
        }
    }

    private fun setUpObservers() {
        lifecycleScope.launch {
            viewModel.category.observe(viewLifecycleOwner) { response ->
                meals.clear()
                response?.meals?.let { it -> meals.addAll(it) }
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun onMealClick(model: Meal) {
        val bundle = Bundle()
        bundle.putString(MEAL_ID, model.idMeal)
        bundle.putString(DETAIL_VIEW_MODE, VIEW_DETAIL_FROM_LIST)
        findNavController().navigate(R.id.action_mealListFragment_to_mealDetailFragment, bundle)
    }

    override fun onOptionsMenuClick(model: Meal, view: View, position: Int) {
        displayPopUp(view = view, menu = R.menu.meal_menu, itemId = R.id.like_meal) {
            viewModel.validateMeal(model)
        }
    }
}