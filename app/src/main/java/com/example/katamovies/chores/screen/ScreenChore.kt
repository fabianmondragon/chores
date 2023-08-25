package com.example.katamovies.chores.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.register.dtos.MovieD
import com.example.katamovies.R
import com.example.katamovies.utils.LoadImageFromUrl
import com.example.moviesuikit.spacer.CustomSpacer

@Composable
fun ScreenChore( email: String) {
    BuildSearchBar( email)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuildSearchBar( email: String) {
    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    val emptyString = stringResource(id = R.string.empty_string)

    SearchBar(
        modifier = Modifier.fillMaxWidth(),
        query = text,
        onQueryChange = {
            text = it
        },
        onSearch = {
            active = false
            text = ""
        },
        active = true,
        onActiveChange = {
            active = it
        },
        placeholder = {
            Text(text = stringResource(id = R.string.search))
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
        },
        trailingIcon = {
            if (active) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close Icon",
                    modifier = Modifier.clickable {
                        if (text.isNotEmpty()) {
                            text = emptyString
                        } else {
                            active = false
                        }
                        text = emptyString
                    }
                )
            }
        }
    ) {
        Surface(
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.fillMaxWidth()
        ) {

            Column {
                BuildBody(email)
            }
        }
    }
}

@Composable
fun BuildBody(email: String) {
    Button(onClick = { }) {
        Text(text = email)
    }
}


