package com.example.shoporganizer.home

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.shoporganizer.R
import com.example.shoporganizer.data.ShopRepo
import com.example.shoporganizer.data.model.ShopItem
import com.example.shoporganizer.data.model.ShopProfile
import com.example.shoporganizer.data.model.Type

@Composable
fun HomeScreen(modifier: Modifier = Modifier, selectedItem: (Int) -> Unit,) {

    val context = LocalContext.current
    val shopItemList = remember { ShopRepo.getShopItems(context) }
    val profile = remember { ShopRepo.profile}

    Column(
        modifier
            .verticalScroll(rememberScrollState())
    ) {

        HomeHeader(profile = profile)
        HomeSection(title = R.string.crochet_label) {
            ShopItemsGrid(shopItems = shopItemList.filter {
                    shopItem -> shopItem.type == Type.CROCHET
            }, selectedItem = selectedItem)
        }
        Spacer(Modifier.height(16.dp))
        HomeSection(title = R.string.knit_label) {
            ShopItemsGrid(shopItems = shopItemList.filter {
                    shopItem -> shopItem.type == Type.KNIT
            }, selectedItem = selectedItem)
        }
    }
}

@Composable
private fun HomeHeader(
    profile: ShopProfile
) {
    Box {
        TopAppBar(
            backgroundColor = MaterialTheme.colorScheme.surfaceVariant,
            elevation = 0.dp,
            modifier = Modifier
                .height(150.dp)
                .clip(
                    RoundedCornerShape(
                        bottomStart = 24.dp,
                        bottomEnd = 24.dp
                    )
                )

        ) {
            Column {
                Text(
                    text = stringResource(R.string.welcome_header),
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.secondary,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .paddingFromBaseline(top = 40.dp)
                )
                Text(
                    text = profile.firstName,
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .paddingFromBaseline(top = 20.dp, bottom = 16.dp)
                )
            }
        }
    }
}

@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.secondary,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
        )
        content()
    }
}

@Composable
fun ShopItemsGrid(
    modifier: Modifier = Modifier,
    shopItems: List<ShopItem>,
    selectedItem: (Int) -> Unit,
) {
    val scrollState = rememberLazyGridState()
    LazyHorizontalGrid(
        rows = GridCells.Fixed(3),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        state = scrollState,
        modifier = modifier.height(250.dp)

    ) {
        itemsIndexed(shopItems) { _, item ->
            ShopItemCard(item, selectedItem)
        }
    }
}

@Composable
fun ShopItemCard(
    item: ShopItem,
    selectedItem: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        shape = MaterialTheme.shapes.large,
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        val context = LocalContext.current
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .width(255.dp)
                .clickable {
                    selectedItem(item.id)
                },
        ) {
            Image(
                painter = painterResource(item.itemImageId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)
            )
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp),
            )
        }
    }
}
