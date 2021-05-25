package hu.digitalthinkers.expense.tracker.data.localRepository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hu.digitalthinkers.expense.tracker.data.models.ExpenseModel
import hu.digitalthinkers.expense.tracker.ui.utils.Constants

/*
 * Data Access Object
 */
@Dao
interface LocalRepo {

    /**
     * addExpenseRecord(model: ExpenseModel) - This method takes ExpenseModel and adds it to Room Database
     *
     * @param model - ExpenseModel Model which needs to be saved in database
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addExpenseRecord(model: ExpenseModel)

    /**
     * getAllExpenseRecords() - This method returns list of expense models from room database wrapped in LiveData.
     *                        - Because of LiveData, the client side will be able to observe list of models for changes
     *
     * @return LiveData<List<ExpenseModel>> - List of expense models, wrapped in LiveData
     */
    @Query("Select * from ${Constants.DATABASE_TABLE_EXPENSE} order by id DESC")
    fun getAllExpenseRecords(): LiveData<List<ExpenseModel>>

}