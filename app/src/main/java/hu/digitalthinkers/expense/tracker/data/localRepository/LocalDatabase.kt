package hu.digitalthinkers.expense.tracker.data.localRepository

import androidx.room.Database
import androidx.room.RoomDatabase
import hu.digitalthinkers.expense.tracker.data.models.ExpenseModel

/**
 * LocalDatabase - Abstract class for extending the Room database. We cannot create an instance of a RoomDatabase, so this class is also abstract.
 * We have also mentioned the database tables (model classes, ExpenseModel) and database version
 */
@Database(entities = [ExpenseModel::class], version = 1, exportSchema = false)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun getDao(): LocalRepo
}