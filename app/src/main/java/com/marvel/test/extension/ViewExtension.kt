package com.marvel.test.extension

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.text.TextUtils
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.marvel.test.R

fun Activity.configRecyclerViewAsGrid(recyclerView: RecyclerView, numColumns: Int) {
    val layoutManager = GridLayoutManager(this, numColumns)
    recyclerView.layoutManager = layoutManager
    val animation: LayoutAnimationController =
        AnimationUtils.loadLayoutAnimation(
            applicationContext,
            R.anim.recycler_animation_fall_down
        )
    recyclerView.layoutAnimation = animation
}

fun Fragment.configRecyclerViewAsGrid(recyclerView: RecyclerView, numColumns: Int) {
    val layoutManager = GridLayoutManager(context, numColumns)
    recyclerView.layoutManager = layoutManager
    val animation: LayoutAnimationController =
        AnimationUtils.loadLayoutAnimation(
            context,
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

fun ImageView.loadRemoteImage(imageUrl: String){
    Glide
        .with(this.context)
        .load(imageUrl)
        .into(this)
}