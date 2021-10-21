package pro.aidar.mealsapp.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.aidar.data.base.model.Meal
import dagger.hilt.android.AndroidEntryPoint
import pro.aidar.mealsapp.R

@AndroidEntryPoint
class StubActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stub)
    }
}