package pro.aidar.mealsapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aidar.data.base.model.Meal
import pro.aidar.mealsapp.R
import pro.aidar.mealsapp.databinding.ItemMealBinding
import pro.aidar.mealsapp.utils.setThrottleOnClickListener
import java.util.*

class MealsAdapter(private var list: ArrayList<Meal>, private val listener: MealListener) :
    RecyclerView.Adapter<MealsAdapter.MealsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealsViewHolder {
        val binding: ItemMealBinding? =
            DataBindingUtil.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_meal, parent, false))
        return MealsViewHolder(binding!!)
    }

    override fun onBindViewHolder(holder: MealsViewHolder, position: Int) {
        holder.onBind(model = list[position], position = position)
    }

    inner class MealsViewHolder(val binding: ItemMealBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: Meal, position: Int) {
            binding.model = model
            binding.like.setThrottleOnClickListener {
                listener.onOptionsMenuClick(model = model, view = binding.like, position = position)
            }
            itemView.setOnClickListener {
                listener.onMealClick(model = model)
            }
        }
    }

    override fun getItemCount() = list.size

    fun removeItem(model: Meal, position: Int) {
        list.remove(model)
        notifyItemRemoved(position)
    }

    interface MealListener {
        fun onMealClick(model: Meal)
        fun onOptionsMenuClick(model: Meal, view: View, position: Int)
    }
}