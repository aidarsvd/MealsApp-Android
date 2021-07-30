package pro.aidar.mealsapp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import kotlinx.coroutines.MainScope

abstract class BaseActivity<DataBinding : ViewDataBinding>(private val layoutId: Int) :
    AppCompatActivity() {

    protected lateinit var binding: DataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this
        setupView()
    }

    abstract fun setupView()
}