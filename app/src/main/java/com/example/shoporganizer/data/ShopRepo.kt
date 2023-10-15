package com.example.shoporganizer.data

import android.content.Context
import com.example.shoporganizer.R
import com.example.shoporganizer.data.model.ShopItem
import com.example.shoporganizer.data.model.ShopProfile
import com.example.shoporganizer.data.model.Type

object ShopRepo {

    fun getItem(itemId: Int): ShopItem = getShopItems().find {
        it.id == itemId
    }!!
    fun getShopItems() = listOf(
        ShopItem(
            id = 1,
            type = Type.CROCHET,
            title = "Mini Dino",
            description = "Mini crocheted plush dinosaur",
            quantity = "1",
            rating = 5,
            itemImageId = R.drawable.item1
        ),
        ShopItem(
            id = 2,
            type = Type.CROCHET,
            title = "Mini Bee",
            description = "Mini crocheted plush bee",
            quantity = "3",
            rating = 4,
            itemImageId = R.drawable.item2
        ),
        ShopItem(
            id = 3,
            type = Type.CROCHET,
            title = "Mini Dragon",
            description = "Mini crocheted plush dragon",
            quantity = "5",
            rating = 5,
            itemImageId = R.drawable.item3
        ),
        ShopItem(
            id = 4,
            type = Type.CROCHET,
            title = "Dino Lovey",
            description = "Soft crocheted dino lovey",
            quantity = "1",
            rating = 5,
            itemImageId = R.drawable.item4
        ),
        ShopItem(
            id = 5,
            type = Type.CROCHET,
            title = "Mermaid Bunny",
            description = "Small crocheted plush mer-bunny",
            quantity = "1",
            rating = 5,
            itemImageId = R.drawable.item5
        ),
        ShopItem(
            id = 6,
            type = Type.CROCHET,
            title = "Bunny Lovey",
            description = "Soft crocheted bunny lovey",
            quantity = "1",
            rating = 4,
            itemImageId = R.drawable.item6
        ),
        ShopItem(
            id = 7,
            type = Type.CROCHET,
            title = "Pacifier Clips",
            description = "Wooden and crocheted bunny pacifier clips",
            quantity = "2",
            rating = 4,
            itemImageId = R.drawable.item7
        ),
        ShopItem(
            id = 8,
            type = Type.CROCHET,
            title = "Chick Hatching",
            description = "Hatching little plush chick with egg",
            quantity = "1",
            rating = 5,
            itemImageId = R.drawable.item8
        ),
        ShopItem(
            id = 9,
            type = Type.KNIT,
            title = "Head-warmers",
            description = "Knitted head-warmers",
            quantity = "10",
            rating = 4,
            itemImageId = R.drawable.item9
        ),
        ShopItem(
            id = 10,
            type = Type.CROCHET,
            title = "Teether",
            description = "Wooden bunny teether with crocheted lovey blanket",
            quantity = "0",
            rating = 1,
            itemImageId = R.drawable.item10
        )
    )
    val profile = ShopProfile (firstName = "Shantelle",
        shopName = "Little Hops Studio",
        email = "shantelle@littlehopsstudio.com",
        website = "littlehopsstudio.com",
        location = "Central NY",
        itemImageId = R.drawable.logo
    )
}

