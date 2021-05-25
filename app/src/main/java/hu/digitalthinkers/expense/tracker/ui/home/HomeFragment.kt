package hu.digitalthinkers.expense.tracker.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import hu.digitalthinkers.expense.tracker.R
import hu.digitalthinkers.expense.tracker.data.models.ExpenseModel
import hu.digitalthinkers.expense.tracker.databinding.FragmentHomeBinding
import hu.digitalthinkers.expense.tracker.ui.base.BaseFragment

/**
 * HomeFragment - Shows list of expenses to user
 */
@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    // view binding
    override fun provideBinding() = FragmentHomeBinding.inflate(layoutInflater)

    // list of expense records
    private val listOfExpenseRecords = ArrayList<ExpenseModel>()

    // view model
    private val viewModel: HomeFragmentViewModel by viewModels()

    // adapter for recyclerview
    private val adapter: HomeFragmentAdapter = HomeFragmentAdapter(listOfExpenseRecords)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()

        binding?.let { layout ->

            // setting layout manager and adapter for recyclerview
            layout.recView.let {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.adapter = adapter
            }

            // getting all expenses from database and observing for any changes
            viewModel.getAllExpenseRecords().observe(viewLifecycleOwner, {
                it?.let { models ->
                    calculateTotal(models)
                    listOfExpenseRecords.clear()
                    listOfExpenseRecords.addAll(models)
                    adapter.notifyDataSetChanged()
                }
            })

            // navigate to Create Expense Fragment on click of Fab button
            layout.btnAddExpense.setOnClickListener {
                navController.navigate(HomeFragmentDirections.actionHomeFragmentToCreateExpenseFragment())
            }

        }

    }

    /**
     * calculateTotal(models: List<ExpenseModel>) - This method takes list of expense models, calculate sum and display
     */
    private fun calculateTotal(models: List<ExpenseModel>) {
        var sum = 0.0
        models.forEach {
            sum += it.amount
        }
        binding?.tvTotalExpense?.text = getString(R.string.total_with_value, sum.toString())
    }

}