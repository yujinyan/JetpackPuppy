package com.example.androiddevchallenge

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.androiddevchallenge.utils.Navigator

@Composable
fun PuppyListScreen(navigator: Navigator<Destination>) = Scaffold(
    topBar = { TopAppBar(title = { Text(text = "JetpackPuppies") }) }
) {
    LazyColumn(
        Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = padding, vertical = padding),
        verticalArrangement = Arrangement.spacedBy(padding)
    ) {
        items(puppies) {
            PuppyCard(puppy = it, onClick = { navigator.navigate(Destination.Detail(it)) })
        }
    }
}