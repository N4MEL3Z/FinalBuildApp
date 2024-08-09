package com.example.buildapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val name1: Int,
    val availableCourses: Int,
    @DrawableRes val imageRes: Int
)