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
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.utils.Navigator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "JetpackPuppies"
        setContent {
            MyApp(onBackPressedDispatcher)
        }
    }
}

@Composable
fun MyApp(backDispatcher: OnBackPressedDispatcher) {
    val navigator: Navigator<Destination> =
        rememberSaveable(saver = Navigator.saver(backDispatcher)) {
            Navigator(Destination.List, backDispatcher)
        }

    MyTheme {
        Crossfade(navigator.current) { destination: Destination ->
            when (destination) {
                is Destination.List -> PuppyListScreen(navigator)
                is Destination.Detail -> PuppyDetailScreen(puppy = destination.puppy)
            }
        }
    }
}



val padding = 16.dp

@Composable
fun PuppyCard(puppy: Puppy, onClick: () -> Unit) {
    Card(
        Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
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
    PuppyCard(puppy = puppies.first()) {}
}
