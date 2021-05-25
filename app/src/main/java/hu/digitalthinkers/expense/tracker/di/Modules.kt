package hu.digitalthinkers.expense.tracker.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import hu.digitalthinkers.expense.tracker.data.localRepository.LocalDatabase
import hu.digitalthinkers.expense.tracker.data.localRepository.LocalRepo
import hu.digitalthinkers.expense.tracker.ui.utils.Constants
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Modules {

    @Singleton
    @Provides
    fun provideLocalDatabase(@ApplicationContext context: Context): LocalDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            LocalDatabase::class.java,
            Constants.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideLocalRepo(localDatabase: LocalDatabase): LocalRepo {
        return localDatabase.getDao()
    }

}