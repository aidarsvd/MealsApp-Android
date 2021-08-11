package pro.aidar.mealsapp.ui.random

import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import pro.aidar.mealsapp.R
import pro.aidar.mealsapp.base.BaseActivity
import pro.aidar.mealsapp.databinding.ActivityRandomBinding

@AndroidEntryPoint
class RandomActivity : BaseActivity<ActivityRandomBinding>(R.layout.activity_random) {
    val viewModel: RandomViewModel by viewModels()

    override fun setupView() {
        viewModel.getRandom()
    }
}