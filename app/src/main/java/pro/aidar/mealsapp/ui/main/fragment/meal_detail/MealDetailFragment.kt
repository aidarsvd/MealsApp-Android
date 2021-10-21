//package pro.aidar.mealsapp.ui.main.fragment.meal_detail
//
//import androidx.fragment.app.activityViewModels
//import androidx.lifecycle.lifecycleScope
//import kotlinx.coroutines.flow.collect
//import kotlinx.coroutines.flow.drop
//import kotlinx.coroutines.launch
//import pro.aidar.mealsapp.R
//import pro.aidar.mealsapp.base.BaseFragment
//import pro.aidar.mealsapp.databinding.FragmentMealDetailBinding
//import pro.aidar.mealsapp.model.meal.Meal
//import pro.aidar.mealsapp.ui.main.viewModel.MainViewModel
//import pro.aidar.mealsapp.utils.AppConstant.DETAIL_VIEW_MODE
//import pro.aidar.mealsapp.utils.AppConstant.MEAL_ID
//import pro.aidar.mealsapp.utils.AppConstant.MEAL_PRIMARY_KEY
//import pro.aidar.mealsapp.utils.AppConstant.VIEW_DETAIL_FROM_FAV
//import pro.aidar.mealsapp.utils.displayPopUp
//import pro.aidar.mealsapp.utils.getYouTubeVideoId
//import pro.aidar.mealsapp.utils.watchYoutubeVideo
//
//class MealDetailFragment : BaseFragment<FragmentMealDetailBinding>(R.layout.fragment_meal_detail) {
//
//    private lateinit var mealId: String
//    private lateinit var viewMode: String
//    private var videoUrl: String? = null
//    private val viewModel: MainViewModel by activityViewModels()
//    var meal = Meal()
//
//    override fun setUpView() {
//        initMealId()
//        getMealDetail()
//        initObserver()
//        initClick()
//    }
//
//    private fun initMealId() {
//        arguments.let {
//            mealId = it!!.getString(MEAL_ID)!!
//            viewMode = it.getString(DETAIL_VIEW_MODE)!!
//        }
//    }
//
//    private fun getMealDetail() {
//        viewModel.getMealDetail(id = mealId)
//    }
//
//    private fun initObserver() {
//        lifecycleScope.launch {
//            viewModel.detailMeal
//                .drop(1)
//                .collect {
//                    with(it.meals!![0]) {
//                        binding.model = this
//                        videoUrl = strYoutube
//                        meal.idMeal = mealId
//                        meal.strMeal = strMeal
//                        meal.strMealThumb = strMealThumb
//                    }
//                }
//        }
//    }
//
//    private fun initClick() {
//        binding.youtube.setOnClickListener {
//            watchYoutubeVideo(requireContext(), videoUrl!!.getYouTubeVideoId())
//        }
//        binding.backBtn.setOnClickListener {
//            requireActivity().onBackPressed()
//        }
//
//        binding.more.setOnClickListener {
//            setUpOptionMode(mode = viewMode)
//        }
//    }
//
//    private fun setUpOptionMode(mode: String) {
//        if (mode == VIEW_DETAIL_FROM_FAV)
//            displayPopUp(
//                view = binding.more,
//                menu = R.menu.meal_favorite_menu,
//                itemId = R.id.unlike_meal
//            ) {
//                meal.id = arguments?.getInt(MEAL_PRIMARY_KEY)
//                viewModel.deleteMealFromFavorite(meal = meal)
//            }
//        else
//            displayPopUp(
//                view = binding.more,
//                menu = R.menu.meal_menu,
//                itemId = R.id.like_meal
//            ) {
//                viewModel.validateLike(name = meal)
//            }
//    }
//}