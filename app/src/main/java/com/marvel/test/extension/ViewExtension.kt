package com.marvel.test.extension

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.text.TextUtils
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

fun Activity.showErrorDialog(
    message: String,
    cancelable: Boolean
) {
    val builder = AlertDialog.Builder(this)
    builder.setCancelable(cancelable)
    builder.setMessage(message)
    builder.setPositiveButton(R.string.accept_alert_button, null)
    builder.create().show()
}