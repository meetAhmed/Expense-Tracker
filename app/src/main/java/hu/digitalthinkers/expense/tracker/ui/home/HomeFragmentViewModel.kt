package hu.digitalthinkers.expense.tracker.ui.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.digitalthinkers.expense.tracker.data.localRepository.LocalRepo
import javax.inject.Inject

/**
 * HomeFragmentViewModel - Bridge between HomeFragment and LocalRepository
 */
@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val localRepo: LocalRepo
) : ViewModel() {

    /**
     * getAllExpenseRecords() - This method returns list of expense models from room database wrapped in LiveData.
     *                        - Because of LiveData, the client side will be able to observe list of models for changes
     *
     * @return LiveData<List<ExpenseModel>> - List of expense models, wrapped in LiveData
     */
    fun getAllExpenseRecords() = localRepo.getAllExpenseRecords()

}