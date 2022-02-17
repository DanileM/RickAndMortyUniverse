package com.androidtavern.rickandmortyuniverse.presentation.utils

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide

fun ImageView.loadByUrlWithPlaceholder(url: String?, @DrawableRes placeholder: Int) {
    Glide.with(this)
        .load(url)
        .placeholder(placeholder)
        .into(this)
}