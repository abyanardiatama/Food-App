package com.example.smartphoneapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Food (
    val name: String,
    val image: String,
    val description: String
): Parcelable