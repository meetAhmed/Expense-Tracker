package hu.digitalthinkers.expense.tracker.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * BaseFragment - To reduce code redundancy
 */
abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    var binding: VB? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = provideBinding()
        return binding?.root
    }

    abstract fun provideBinding(): VB

}