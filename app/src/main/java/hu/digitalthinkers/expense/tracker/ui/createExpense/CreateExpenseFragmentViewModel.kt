package hu.digitalthinkers.expense.tracker.ui.createExpense

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.digitalthinkers.expense.tracker.data.localRepository.LocalRepo
import hu.digitalthinkers.expense.tracker.data.models.ExpenseModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * CreateExpenseFragmentViewModel - Bridge between CreateExpenseFragment and LocalRepository
 */
@HiltViewModel
class CreateExpenseFragmentViewModel @Inject constructor(
    private val localRepo: LocalRepo
) : ViewModel() {

    /**
     * addExpenseRecord(title: String, amount: String, category: String) - This method takes title, amount and category
     *                                                                   - and then create Expense Model and pass it to
     *                                                                   - repository to store in database
     */
    fun addExpenseRecord(title: String, amount: Double, category: String) = viewModelScope.launch {
        localRepo.addExpenseRecord(ExpenseModel(title, amount, category))
    }

}