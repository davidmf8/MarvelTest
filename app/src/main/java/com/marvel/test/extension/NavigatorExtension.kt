package com.marvel.test.extension

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import com.marvel.test.R

fun Context.openInternalUrl(url: String) {
    val builder = CustomTabsIntent.Builder()
    val customTabsIntent = builder.build()
    customTabsIntent.intent.putExtra(
        CustomTabsIntent.EXTRA_TOOLBAR_COLOR,
        ContextCompat.getColor(
            this, R.color.purple_700
        )
    )
    customTabsIntent.intent.putExtra(
        CustomTabsIntent.EXTRA_SECONDARY_TOOLBAR_COLOR,
        ContextCompat.getColor(
            this, R.color.purple_700
        )
    )
    customTabsIntent.launchUrl(this, Uri.parse(url))
}