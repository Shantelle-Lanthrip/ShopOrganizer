package com.example.shoporganizer.data.model

import java.io.Serializable

data class ShopItem(
    val id: Int,
    val type: Type,
    val title: String,
    val description: String,
    val itemImageId: Int = 0
) : Serializable