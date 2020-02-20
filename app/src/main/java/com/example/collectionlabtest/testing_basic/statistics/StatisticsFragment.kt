
package com.example.collectionlabtest.testing_basic.statistics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.collectionlabtest.testing_basic.util.setupRefreshLayout
import com.example.collectionlabtest.R
import com.example.collectionlabtest.databinding.StatisticsFragBinding

/**
 * Main UI for the statistics screen.
 */
class StatisticsFragment : Fragment() {

    private lateinit var viewDataBinding: StatisticsFragBinding

    private val viewModel by viewModels<StatisticsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate(
            inflater, R.layout.statistics_frag, container,
            false
        )
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.viewmodel = viewModel
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
        this.setupRefreshLayout(viewDataBinding.refreshLayout)
    }
}
