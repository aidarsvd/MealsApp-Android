package pro.aidar.mealsapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import pro.aidar.mealsapp.R

@AndroidEntryPoint
class StubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stub)
    }
}