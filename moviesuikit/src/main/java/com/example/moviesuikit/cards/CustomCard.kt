package com.example.moviesuikit.cards

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class CustomCard {
    companion object {

        @Composable
        fun BuildCardChore(
            title: String,
            date: String,
            onclick: () -> Unit = {}

        ) {
            Card(
                modifier = Modifier.padding(8.dp)

            ) {
                Text(
                    text = title,
                    modifier = Modifier.padding(8.dp)
                )

                Text(
                    text = date,
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.End)
                )

                /*Button(
                    onClick = {
                        onclick.invoke()
                    }
                ){
                    Text(text = "Done")

                }*/

            }
        }
    }
}

