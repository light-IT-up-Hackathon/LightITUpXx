package com.example.lightitupxx.api

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Facility_info (
    val image : Int,
    val name : String,
    val field : String,
    val time : String,
    val location :String,
    val latitude:Double?,
    val longtitude:Double?
    ) : Parcelable