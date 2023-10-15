package com.example.shoporganizer.presentation.screen.home

import androidx.lifecycle.ViewModel
import com.example.shoporganizer.data.ShopRepo
import com.example.shoporganizer.data.model.ShopItem
import com.example.shoporganizer.data.model.ShopProfile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel(): ViewModel() {
    private val shopRepo = ShopRepo

    private val _itemList = MutableStateFlow<List<ShopItem>>(emptyList())
    val itemList = _itemList.asStateFlow()

    private val _profile : MutableStateFlow<ShopProfile?> = MutableStateFlow(null)
    val profile = _profile.asStateFlow()

    init {
        _itemList.value = shopRepo.getShopItems()
        _profile.value = shopRepo.profile
    }
}