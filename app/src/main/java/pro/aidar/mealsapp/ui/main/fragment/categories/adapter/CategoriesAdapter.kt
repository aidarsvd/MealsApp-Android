package pro.aidar.mealsapp.ui.main.fragment.categories.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aidar.data.data.meals.get_meal_categories.dto.Category
import pro.aidar.mealsapp.R
import pro.aidar.mealsapp.databinding.ItemCategoryBinding
import java.util.*

class CategoriesAdapter(private val list: ArrayList<Category>, private val listener: CategoriesListener) :
    RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val binding: ItemCategoryBinding? =
            DataBindingUtil.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false))
        return CategoriesViewHolder(binding!!)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size

    inner class CategoriesViewHolder(private val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: Category) {
            binding.model = model
            itemView.setOnClickListener {
                listener.onCategoryClick(model)
            }
        }
    }

    interface CategoriesListener {
        fun onCategoryClick(category: Category)
    }
}