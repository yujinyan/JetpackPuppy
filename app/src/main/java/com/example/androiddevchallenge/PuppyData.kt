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

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Puppy(
    val name: String,
    val gender: Gender,
    val breed: String,
    val description: String,
    @DrawableRes
    val image: Int,
    val fees: Float
) : Parcelable {
    enum class Gender { Male, Female }
}

/**
 * https://github.com/cheezy/puppies
 */
val puppies = listOf(
    Puppy(
        name = "Maggie Mae",
        breed = "Border Colie Mix",
        description = """
            Very sweet and playful. She was dumped in a deserted area in Cleveland, one of our
                volunteers stopped to feed her and she ran after the van as she drove away.  Needless
                to say she was crying for help!  She was first timid and shy and now she has regained
                her trust in people.  Maggie is very gentle and calm.
        """.trimIndent(),
        gender = Puppy.Gender.Female,
        image = R.drawable.maggiemae,
        fees = 14.95f
    ),

    Puppy(
        name = "Spud",
        breed = "Beagle/Hound Mix",
        description = """
This 2 year old handsome boy is housetrained, and loves riding in the car.  He is playful
and friendly and would make a great addition to your family.
""",
        gender = Puppy.Gender.Female,
        image = R.drawable.spud,
        fees = 18.75f
    ),

    Puppy(
        name = "Hanna",
        breed = "Labrador Retriever Mix",
        description = """
            Little Hannah is 3 mos old . She is energetic, loves to play with other dogs and fetch !She is a
    lovable - playful, typical puppy personality.Hannah is a very confident little girl who is always ready to go go go
    !Hannah is working on basic manners with her forster mon, but would benefit from puppy obedience school.She is also crate trained . If you are interested
            in adding a new puppy to your family, please contact us to see if you are a good match.",
        """.trimIndent(),
        gender = Puppy.Gender.Female,
        image = R.drawable.hannah,
        fees = 22.99f
    ),

    Puppy(
        name = "Brook",
        breed = "Golden Retriever",
        description = """
                This young lady is trying to put her shelter eperience behind her.She\
    's only about 7
            months old,
    and as you can see from her picture,
    she loves her toys !!Basically a blank
            slate as far as training,
    she\'ll fit into a new home very quickly.
        """.trimIndent(),
        gender = Puppy.Gender.Female,
        image = R.drawable.brook,
        fees = 34.95f,
    ),

    Puppy(
        name = "Topsy",
        breed = "Terrier Mix",
        description = """
                    This little girl is around 4 - 5 weeks old,
            and came in with hr mom sister,
            and two brothers.She is a
            typical puppy,
            not much more to say about that.She is just
            sweet, playful, and is a baby.
        """.trimIndent(),
        gender = Puppy.Gender.Female,
        image = R.drawable.topsy,
        fees = 42f,
    ),
    Puppy(
        name = "Tipsy",
        breed = "Terrier Mix",
        description = """
                This little girl is around 4 - 5 weeks old,
        and came in with hr mom sister,
        and two brothers.She is a
        typical puppy,
        not much more to say about that.She is just sweet, playful,
        and is a baby.",
        """.trimIndent(),
        gender = Puppy.Gender.Female,
        image = R.drawable.tipsy,
        fees = 42f,
    ),
    Puppy(
        name = "Twinkie",
        breed = "Boxer/Rat Terrier Mix",
        description = """
            This little girl was the runt and she has tons of energy.Twinkie is a
    ten week old
            youngster looking
    for her forever home.Her momma is a Boxer / Rat Terrier / GSD and
            daddy is a Rat Terrier / Boston Terrier.Twinkie is a very sweet and petite little girl
        """.trimIndent(),
        gender = Puppy.Gender.Female,
        image = R.drawable.twinkie,
        fees = 22.50f,
    ),
    Puppy(
        name = "Ruby Sue",
        breed = "Pit Bull Terrier",
        description = """
        
            Cute,
    fun , and ready to play!! Meet Ruby Sue . She is a 4 month old leggy little
            red nose pit bull.She is 20
    lbs.of playful pup.She loves tug of war,
    fetch walks,
    runs,
    and anything you 're up for.  On her softer side she also enjoys long belly
            rubs on her adorable piglet belly.
        """.trimIndent(),
        gender = Puppy.Gender.Female,
        image = R.drawable.ruby_sue,
        fees = 52.50f,
    ),

    Puppy(
        name = "Sparky",
        breed = "Austrailian Cattle Dog (Blue Heeler)",
        description = """
                Sparky is a deaf blue heeler male pup with special needs . He is eight weeks old,
        neutered,
        and already well traveled . Sparky has such a charming personality,
        and is already learning that people are not his chew toys .
        """.trimIndent(),
        gender = Puppy.Gender.Male,
        image = R.drawable.sparky,
        fees = 79.99f
    ),
)
