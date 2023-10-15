package com.example.shoporganizer.presentation.screen.item

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.shoporganizer.data.ShopRepo
import com.example.shoporganizer.data.model.ShopItem
import com.example.shoporganizer.utils.Constants.ITEM_ARGUMENT_KEY
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ItemDetailViewModel(saveStatedHandle: SavedStateHandle) : ViewModel() {
    private val shopRepo = ShopRepo

    private val _itemDetail: MutableStateFlow<ShopItem?> = MutableStateFlow(null)
    val itemDetail = _itemDetail.asStateFlow()

    init {
        val itemId = saveStatedHandle.get<Int>(ITEM_ARGUMENT_KEY) ?: 0
        _itemDetail.value = shopRepo.getItem(itemId)
    }
}