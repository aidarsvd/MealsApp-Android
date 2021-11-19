package pro.aidar.mealsapp.base

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

open class BaseViewModel : ViewModel() {
    var isLoad = ObservableField(true)

    val disposable: CompositeDisposable by lazy {
        return@lazy CompositeDisposable()
    }
}