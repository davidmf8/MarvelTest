package com.marvel.test.base

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.marvel.test.R
import com.marvel.test.base.analitycs.AnalyticsPresenter
import com.marvel.test.base.analitycs.IAnalyticsPresenter
import org.koin.androidx.viewmodel.ext.android.viewModel

abstract class BaseActivity : AppCompatActivity() {

    private val analyticsPresenter: IAnalyticsPresenter by viewModel<AnalyticsPresenter>()

    abstract fun getViewName(): String?
    abstract fun loadObservers()
    abstract fun removeObservers()

    override fun onResume() {
        super.onResume()
        analyticsPresenter.trackView(getViewName(), localClassName)
    }

    override fun onDestroy() {
        removeObservers()
        super.onDestroy()
    }

    override fun onBackPressed() {
        overridePendingTransition(R.anim.slide_to_bottom, R.anim.no_animation)
        super.onBackPressed()
    }
}
