package pro.aidar.mealsapp.base

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    var isLoad = ObservableField(true)
}