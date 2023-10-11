package com.example.shoporganizer.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.shoporganizer.R
import com.example.shoporganizer.data.ShopRepo
import com.example.shoporganizer.data.model.ShopProfile

@Composable
fun ProfileScreen() {
    val profile = remember {ShopRepo.profile}
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.fillMaxSize()) {
        BoxWithConstraints {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState),
                ) {
                    ProfileHeader(profile)
                    ProfileContent(profile)
                }
            }
        }
    }
}

@Composable
private fun ProfileHeader(profile: ShopProfile) {
    Image(
        painter = painterResource(id = profile.itemImageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
    )
}

@Composable
private fun Title(profile: ShopProfile) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = profile.shopName,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
        )
    }
}

@Composable
fun ProfileProperty(label: String, value: String) {
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
private fun ProfileContent(profile: ShopProfile) {
    Column {
        Title(profile)
        ProfileProperty(stringResource(id = R.string.email_label), profile.email)
        ProfileProperty(stringResource(id = R.string.website_label), profile.website)
        ProfileProperty(stringResource(id = R.string.location_label), profile.location)
    }
}
