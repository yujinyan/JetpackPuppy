package com.example.androiddevchallenge

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class Destination : Parcelable {
    @Parcelize
    object List : Destination()

    @Parcelize
    data class Detail(val puppy: Puppy) : Destination()
}
