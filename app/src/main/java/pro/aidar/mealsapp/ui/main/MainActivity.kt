package pro.aidar.mealsapp.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import pro.aidar.mealsapp.R
import pro.aidar.mealsapp.base.BaseActivity
import pro.aidar.mealsapp.databinding.ActivityMainBinding
import pro.aidar.mealsapp.ui.main.viewModel.MainViewModel
import pro.aidar.mealsapp.utils.setupWithNavController
import pro.aidar.mealsapp.utils.showToast
import pro.aidar.mealsapp.utils.status.LikeStatus

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel: MainViewModel by viewModels()
    private var currentNavController: LiveData<NavController>? = null

    override fun setupView() {
        setupBottomNavigationBar()
        subscribeToEvent()
    }

    private fun setupBottomNavigationBar() {
        val navGraphId = listOf(
            R.navigation.category_graph,
            R.navigation.favorite_graph
        )
        val controller = binding.bottomNavigation.setupWithNavController(
            navGraphIds = navGraphId,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host,
            intent = intent
        )
        currentNavController = controller
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setupBottomNavigationBar()
    }

    private fun subscribeToEvent() {
        lifecycleScope.launch {
            viewModel.likeStatus.observe(this@MainActivity) {
                when (it) {
                    LikeStatus.EXIST -> showToast(getString(R.string.already_added))
                    LikeStatus.ERROR -> showToast(getString(R.string.error))
                }
            }
        }
    }
}