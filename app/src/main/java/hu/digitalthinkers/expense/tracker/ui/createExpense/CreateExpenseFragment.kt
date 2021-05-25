package hu.digitalthinkers.expense.tracker.ui.createExpense

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import hu.digitalthinkers.expense.tracker.R
import hu.digitalthinkers.expense.tracker.databinding.FragmentCreateExpenseBinding
import hu.digitalthinkers.expense.tracker.ui.base.BaseFragment
import hu.digitalthinkers.expense.tracker.ui.utils.showToast

/**
 * CreateExpenseFragment - This Fragment allows users to Add New Expense Record
 */
@AndroidEntryPoint
class CreateExpenseFragment : BaseFragment<FragmentCreateExpenseBinding>() {

    // Inflating View Binding
    override fun provideBinding() = FragmentCreateExpenseBinding.inflate(layoutInflater)

    // view model
    private val viewModel: CreateExpenseFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()

        binding?.let { layout ->

            /**
             * Click listener for Add Expense Button
             */
            layout.btnAdd.setOnClickListener {

                val titleStr = layout.etTitle.text.toString().trim()
                val amountStr = layout.etAmount.text.toString().trim()
                var amountDouble = 0.0
                var isError = false

                // check if both title and amount are present or not
                // if not then show error to user

                if (amountStr.isEmpty()) {
                    isError = true
                    layout.etAmount.requestFocus()
                    layout.etAmount.error = getString(R.string.amount_required)
                } else {
                    try {
                        amountDouble = amountStr.toDouble()
                        layout.etAmount.clearFocus()
                    } catch (e: Exception) {
                        isError = true
                        layout.etAmount.requestFocus()
                        layout.etAmount.error = getString(R.string.amount_valid_required)
                    }
                }

                if (titleStr.isEmpty()) {
                    layout.etTitle.requestFocus()
                    layout.etTitle.error = getString(R.string.title_required)
                    isError = true
                } else {
                    layout.etTitle.clearFocus()
                }

                if (!isError) {
                    // no error - save the expense record in database
                    viewModel.addExpenseRecord(
                        titleStr,
                        amountDouble,
                        layout.categorySpinner.selectedItem.toString().trim()
                    )
                    // show success message
                    requireActivity().showToast(getString(R.string.add_expense_success))
                    // move back to Home
                    navController.popBackStack()
                }

            }

        }

    }

}