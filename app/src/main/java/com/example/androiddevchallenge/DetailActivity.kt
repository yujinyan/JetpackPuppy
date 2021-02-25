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

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.theme.MyTheme
import java.util.Locale

class DetailActivity : AppCompatActivity() {
    companion object {
        private const val PUPPY: String = "PUPPY"

        fun start(context: Context, puppy: Puppy) {
            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra(PUPPY, puppy)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val puppy: Puppy? = intent.extras?.getParcelable(PUPPY)
        requireNotNull(puppy) { "puppy is null" }
        title = puppy.name
        setContent {
            MyTheme {
                PuppyDetailScreen(puppy = puppy)
            }
        }
    }
}

@Composable
fun PuppyDetailScreen(puppy: Puppy) {
    Surface(Modifier.fillMaxWidth()) {
        Column(Modifier.verticalScroll(rememberScrollState())) {
            Image(
                painter = painterResource(id = puppy.image),
                contentDescription = puppy.name,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Column(Modifier.padding(horizontal = padding)) {
                Spacer(Modifier.height(padding))

                Text(
                    text = puppy.name,
                    fontStyle = FontStyle.Italic,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Black,
                    fontFamily = FontFamily.Cursive
                )
                Spacer(Modifier.height(padding))

                Section(title = "Gender") {
                    Text(text = puppy.gender.toString())
                }
                Spacer(Modifier.height(padding))

                Section(title = "Breed") {
                    Text(text = puppy.breed)
                }
                Spacer(Modifier.height(padding))

                Section(title = "Description") {
                    Text(text = puppy.description)
                }
                Spacer(Modifier.height(padding))
            }
        }
    }
}

@Composable
fun Section(title: String, content: @Composable () -> Unit) {
    Text(
        text = title.toUpperCase(Locale.getDefault()),
        style = MaterialTheme.typography.subtitle1
    )
    Spacer(Modifier.height(padding / 2))
    content()
}

@Composable
@Preview
fun PuppyDetailScreenPreview() {
    PuppyDetailScreen(puppy = puppies.first())
}
