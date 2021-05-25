package hu.digitalthinkers.expense.tracker.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import dagger.hilt.android.AndroidEntryPoint
import hu.digitalthinkers.expense.tracker.R

/**
 * HomeActivity - Host for Fragment Navigation
 */
@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        navController = (supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container)
                as NavHostFragment).navController
        NavigationUI.setupActionBarWithNavController(this, navController)

    }

    /**
     * Overriding so that NavigationUI can handle the toolbar actions
     */
    override fun onSupportNavigateUp(): Boolean {
        navController.navigateUp()
        return super.onSupportNavigateUp()
    }

}