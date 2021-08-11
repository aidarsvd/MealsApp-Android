package pro.aidar.mealsapp.ui.main

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import dagger.hilt.android.AndroidEntryPoint
import pro.aidar.mealsapp.R
import pro.aidar.mealsapp.base.BaseActivity
import pro.aidar.mealsapp.databinding.ActivityMainBinding
import pro.aidar.mealsapp.utils.setupWithNavController

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private var currentNavController: LiveData<NavController>? = null

    override fun setupView() {
        setupBottomNavigationBar()
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
}