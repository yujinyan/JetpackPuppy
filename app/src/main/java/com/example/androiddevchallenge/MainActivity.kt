/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "JetpackPuppies"
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Surface(Modifier.fillMaxWidth(), color = MaterialTheme.colors.background) {
        LazyColumn(
            Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = padding, vertical = padding),
            verticalArrangement = Arrangement.spacedBy(padding)
        ) {
            items(puppies) {
                PuppyCard(puppy = it)
            }
        }
    }
}

val padding = 16.dp

@Composable
fun PuppyCard(puppy: Puppy) {
    val context = LocalContext.current
    Card(
        Modifier
            .fillMaxWidth()
            .clickable(onClick = { DetailActivity.start(context, puppy) }),
        elevation = 4.dp
    ) {
        Row {
            Image(
                painter = painterResource(id = puppy.image),
                null,
                modifier = Modifier
                    .width(112.dp)
                    .height(96.dp),
                contentScale = ContentScale.Crop
            )
            Column(Modifier.padding(start = padding / 2)) {
                Text(text = puppy.name, fontSize = 18.sp, fontWeight = FontWeight.Black)

                val genderEmoji = when (puppy.gender) {
                    Puppy.Gender.Male -> "♂️"
                    Puppy.Gender.Female -> "♀️"
                }
                Text(text = "$genderEmoji ${puppy.gender}", fontSize = 14.sp)
                Text(text = puppy.breed)
            }
        }
    }
}

@Composable
@Preview
fun PuppyCardPreview() {
    PuppyCard(puppy = puppies.first())
}
