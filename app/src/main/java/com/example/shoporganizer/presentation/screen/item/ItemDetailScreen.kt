package com.example.shoporganizer.presentation.screen.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shoporganizer.R
import com.example.shoporganizer.ui.theme.DIMENS_16dp
import com.example.shoporganizer.ui.theme.DIMENS_24dp
import com.example.shoporganizer.ui.theme.DIMENS_250dp
import com.example.shoporganizer.ui.theme.DIMENS_4dp

@Composable
fun ItemDetailScreen(
    itemDetailViewModel: ItemDetailViewModel = viewModel(),
    navigateUp: () -> Unit
) {
    val item by itemDetailViewModel.itemDetail.collectAsState()

    Surface {
        Column(modifier = Modifier
                .fillMaxSize()
        ) {
            Column {
                item?.let { item ->
                    ItemHeader(itemImage = item.itemImageId, navigateUp = navigateUp)
                    ItemTitle(title = item.title)
                    ItemRating(label = stringResource(id = R.string.rating_label), value = item.rating)
                    ItemProperty(label = stringResource(id = R.string.quantity_label), value = item.quantity)
                    ItemProperty(label = stringResource(id = R.string.description_label), value = item.description)
                }
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
                .height(DIMENS_250dp),
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
    Column(modifier = Modifier
        .padding(DIMENS_16dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
        )
    }
}

@Composable
fun ItemProperty(
    label: String,
    value: String
) {
    Column(modifier = Modifier
            .padding(top = DIMENS_16dp, start = DIMENS_16dp, end = DIMENS_16dp)
    ) {
        Divider(modifier = Modifier
            .padding(bottom = 4.dp)
        )
        Text(
            text = label,
            modifier = Modifier.height(DIMENS_24dp),
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.secondary,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = value,
            modifier = Modifier.height(DIMENS_24dp),
            style = MaterialTheme.typography.bodyMedium,
            overflow = TextOverflow.Visible
        )
    }
}

@Composable
fun ItemRating(
    label: String,
    value: Int
) {
    Column(modifier = Modifier
            .padding(top = DIMENS_16dp, start = DIMENS_16dp, end = DIMENS_16dp)
    ) {
        Divider(modifier = Modifier
            .padding(bottom = DIMENS_4dp))
        Text(
            text = label,
            modifier = Modifier.height(DIMENS_24dp),
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


