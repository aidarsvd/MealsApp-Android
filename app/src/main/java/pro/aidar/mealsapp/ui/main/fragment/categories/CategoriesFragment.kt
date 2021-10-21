//package pro.aidar.mealsapp.ui.main.fragment.categories
//
//import android.os.Bundle
//import androidx.fragment.app.activityViewModels
//import androidx.lifecycle.lifecycleScope
//import androidx.navigation.fragment.findNavController
//import java.util.ArrayList
//import kotlinx.coroutines.flow.collect
//import kotlinx.coroutines.launch
//import pro.aidar.mealsapp.R
//import pro.aidar.mealsapp.base.BaseFragment
//import pro.aidar.mealsapp.databinding.FragmentCategoriesBinding
//import pro.aidar.mealsapp.model.category.Category
//import pro.aidar.mealsapp.ui.main.fragment.categories.adapter.CategoriesAdapter
//import pro.aidar.mealsapp.ui.main.viewModel.MainViewModel
//import pro.aidar.mealsapp.utils.AppConstant.CATEGORY_ID
//
//class CategoriesFragment : BaseFragment<FragmentCategoriesBinding>(R.layout.fragment_categories),
//    CategoriesAdapter.CategoriesListener {
//    private val viewModel: MainViewModel by activityViewModels()
//    private lateinit var adapter: CategoriesAdapter
//    private var categories: ArrayList<Category> = ArrayList()
//    override fun setUpView() {
//        binding.viewModel = viewModel
//        getCategories()
//        setAdapter()
//        setObservers()
//    }
//
//    private fun getCategories() {
//        viewModel.getCategories()
//    }
//
//    private fun setObservers() {
//        lifecycleScope.launch {
//            viewModel.categories.collect { response ->
//                categories.clear()
//                response.categories?.let { it -> categories.addAll(it) }
//                adapter.notifyDataSetChanged()
//            }
//        }
//    }
//
//    private fun setAdapter() {
//        lifecycleScope.launch {
//            adapter = CategoriesAdapter(list = categories, listener = this@CategoriesFragment)
//            binding.categoriesRecycler.adapter = adapter
//        }
//    }
//
//    override fun onCategoryClick(category: Category) {
//        val bundle = Bundle()
//        bundle.putString(CATEGORY_ID, category.strCategory)
//        findNavController().navigate(R.id.action_categoriesFragment_to_mealListFragment, bundle)
//    }
//}