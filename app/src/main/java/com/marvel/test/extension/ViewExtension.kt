package com.marvel.test.extension

import android.app.Activity
import android.content.Context
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marvel.test.R

fun Activity.configRecyclerViewAsGrid(recyclerView: RecyclerView, numColumns: Int) {
    val layoutManager = GridLayoutManager(this, numColumns)
    recyclerView.layoutManager = layoutManager
    // Animation
    val animation: LayoutAnimationController =
        AnimationUtils.loadLayoutAnimation(
            applicationContext,
            R.anim.recycler_animation_fall_down
        )
    recyclerView.layoutAnimation = animation
}

fun RecyclerView.recyclerViewSlideFromRightAnimation(context: Context) {
    this.layoutAnimation = AnimationUtils.loadLayoutAnimation(
        context,
        R.anim.recycler_animation_slide_from_right
    )
}