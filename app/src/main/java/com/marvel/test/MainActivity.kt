package com.marvel.test

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import com.marvel.test.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun getViewName(): String? = null

    override fun loadObservers() {
        TODO("Not yet implemented")
    }

    override fun removeObservers() {
        TODO("Not yet implemented")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}