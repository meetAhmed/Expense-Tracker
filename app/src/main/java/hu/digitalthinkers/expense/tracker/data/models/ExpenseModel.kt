package hu.digitalthinkers.expense.tracker.data.models

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.room.Entity
import androidx.room.PrimaryKey
import hu.digitalthinkers.expense.tracker.ui.utils.Constants
import hu.digitalthinkers.expense.tracker.ui.utils.toReadableDate

/**
 * ExpenseModel - A table for Room Database.
 *              - Explains what exactly an Expense Model will contain
 */
@Entity(tableName = Constants.DATABASE_TABLE_EXPENSE)
data class ExpenseModel(
    val title: String,
    val amount: Double,
    val category: String,
    val timestamp: Long = System.currentTimeMillis()
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    companion object {

        /**
         * readableDate(view: TextView, date: Long?) - Binding method for data binding. Used to convert long date
         *                                           - into readable string date.
         */
        @JvmStatic
        @BindingAdapter("readableDate")
        fun readableDate(view: TextView, date: Long?) {
            date?.let {
                view.text = it.toReadableDate()
            }
        }
    }

}