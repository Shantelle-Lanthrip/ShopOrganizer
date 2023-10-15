package com.example.shoporganizer.presentation.screen.profile

import androidx.lifecycle.ViewModel
import com.example.shoporganizer.data.ShopRepo
import com.example.shoporganizer.data.model.ShopProfile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProfileViewModel(): ViewModel() {
    private val shopRepo = ShopRepo

    private val _profile : MutableStateFlow<ShopProfile?> = MutableStateFlow(null)
    val profile = _profile.asStateFlow()

    init {
        _profile.value = shopRepo.profile
    }
}