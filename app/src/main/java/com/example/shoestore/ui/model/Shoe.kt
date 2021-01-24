package com.example.shoestore.ui.model

import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    var name: String = "",
    var size: String = "",
    var company: String = "",
    var description: String = "",
    val images: List<Int> = mutableListOf())
