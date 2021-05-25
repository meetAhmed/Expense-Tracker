package hu.digitalthinkers.expense.tracker.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.recyclerview.widget.RecyclerView
import hu.digitalthinkers.expense.tracker.R
import hu.digitalthinkers.expense.tracker.data.models.ExpenseModel
import hu.digitalthinkers.expense.tracker.databinding.FragmentHomeListItemBinding

/**
 * HomeFragmentAdapter - Manages how each single expense record will be shown to user
 */
class HomeFragmentAdapter(
    private val list: List<ExpenseModel>
) : RecyclerView.Adapter<HomeFragmentAdapter.ViewClass>() {

    // view class
    inner class ViewClass(private val binding: FragmentHomeListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        // Bind expense model with layout
        fun bind(model: ExpenseModel) {
            binding.expenseModel = model
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewClass {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: FragmentHomeListItemBinding =
            inflate(layoutInflater, R.layout.fragment_home_list_item, parent, false)
        return ViewClass(binding)
    }

    override fun onBindViewHolder(holder: ViewClass, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}
