package com.marvel.test.base

import androidx.fragment.app.Fragment
import com.marvel.test.base.analitycs.AnalyticsPresenter
import com.marvel.test.base.analitycs.IAnalyticsPresenter
import org.koin.androidx.viewmodel.ext.android.viewModel

abstract class BaseFragment : Fragment() {
    private val presenter: IAnalyticsPresenter by viewModel<AnalyticsPresenter>()

    abstract fun getViewName(): String?

    override fun onResume() {
        super.onResume()
        activity?.let { presenter.trackView(getViewName(), it.localClassName) }
    }
}
