package com.example.shoporganizer.data.model

import java.io.Serializable

data class ShopProfile(
    val firstName: String,
    val shopName: String,
    val email: String,
    val website: String,
    val location: String,
    val itemImageId: Int = 0
) : Serializable