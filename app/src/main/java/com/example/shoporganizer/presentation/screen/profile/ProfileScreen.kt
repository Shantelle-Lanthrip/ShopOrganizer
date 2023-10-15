package com.example.shoporganizer.presentation.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shoporganizer.R
import com.example.shoporganizer.data.model.ShopProfile
import com.example.shoporganizer.ui.theme.DIMENS_16dp
import com.example.shoporganizer.ui.theme.DIMENS_24dp
import com.example.shoporganizer.ui.theme.DIMENS_250dp
import com.example.shoporganizer.ui.theme.DIMENS_4dp

@Composable
fun ProfileScreen(
    profileViewModel: ProfileViewModel = viewModel(),
) {
    val profile by profileViewModel.profile.collectAsState()

    Surface {
        Column(modifier = Modifier
            .fillMaxSize()
        ) {
            Column {
                profile?.let {profile ->
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
        modifier = Modifier
            .fillMaxWidth()
            .height(DIMENS_250dp)
    )
}

@Composable
private fun Title(profile: ShopProfile) {
    Column(modifier = Modifier
        .padding(DIMENS_16dp)
    ) {
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
    Column(modifier = Modifier
        .padding(top = DIMENS_16dp, start = DIMENS_16dp, end = DIMENS_16dp)
    ) {
        Divider(modifier = Modifier
            .padding(bottom = DIMENS_4dp)
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
private fun ProfileContent(profile: ShopProfile) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
    ) {
        Title(profile)
        ProfileProperty(stringResource(id = R.string.email_label), profile.email)
        ProfileProperty(stringResource(id = R.string.website_label), profile.website)
        ProfileProperty(stringResource(id = R.string.location_label), profile.location)
    }
}
