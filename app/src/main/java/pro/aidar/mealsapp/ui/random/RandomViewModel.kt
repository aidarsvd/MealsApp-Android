package pro.aidar.mealsapp.ui.random

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import pro.aidar.mealsapp.base.BaseViewModel
import pro.aidar.mealsapp.service.Repository

@HiltViewModel
class RandomViewModel @Inject constructor(
    private val repository: Repository
) : BaseViewModel() {

    fun getRandom() {
        var status = true
        runBlocking(context = coroutineContext) {
            while (status) {
                val response = repository.getRandom()
                status = response.meals!![0].strMeal!!.first() != 'C'
                delay(2000)
            }
            return@runBlocking
        }
    }
}