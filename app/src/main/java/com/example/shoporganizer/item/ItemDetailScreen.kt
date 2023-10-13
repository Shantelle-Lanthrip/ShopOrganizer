package com.example.shoporganizer.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.shoporganizer.R
import com.example.shoporganizer.data.ShopRepo
import com.example.shoporganizer.data.model.ShopItem

@Composable
fun ItemDetailScreen(
    itemId: Int,
    navigateUp: () -> Unit
) {

    val context = LocalContext.current

    val item: ShopItem = remember(itemId) {
        ShopRepo.getItem(
            itemId, context
        )
    }

    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            LazyColumn {
                item { ItemHeader(itemImage = item.itemImageId, navigateUp = navigateUp) }
                item { ItemTitle(title = item.title) }
                item { ItemRating(label = stringResource(id = R.string.rating_label), value = item.rating)}
                item { ItemProperty(label = stringResource(id = R.string.quantity_label), value = item.quantity) }
                item { ItemProperty(label = stringResource(id = R.string.description_label), value = item.description) }
            }
        }
    }
}

@Composable
private fun ItemHeader(
    itemImage: Int,
    navigateUp: () -> Unit
) {
    Box {
        Image(
            painter = painterResource(id = itemImage),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop
        )
        TopAppBar(
            backgroundColor = Color.Transparent,
            elevation = 0.dp,
            contentColor = MaterialTheme.colorScheme.primary
        ) {
            IconButton(onClick = navigateUp) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
private fun ItemTitle(title: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
        )
    }
}

@Composable
fun ItemProperty(label: String, value: String) {
    Column(modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)) {
        Divider(modifier = Modifier.padding(bottom = 4.dp))
        Text(
            text = label,
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.secondary,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = value,
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.bodyMedium,
            overflow = TextOverflow.Visible
        )
    }
}

@Composable
fun ItemRating(label: String, value: Int) {
    Column(modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)) {
        Divider(modifier = Modifier.padding(bottom = 4.dp))
        Text(
            text = label,
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.secondary,
            fontWeight = FontWeight.Bold,
        )
        RatingBar(rating = value)
    }
}

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Int,
) {
    Row(modifier = modifier) {
        repeat(rating) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}


