package com.example.katamovies.chores.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.domain.chore.dto.AssignedChoreRespondD
import com.example.domain.chore.dto.ChoreRespondD
import com.example.domain.chore.dto.ScheduleRespondD
import com.example.katamovies.R
import com.example.katamovies.utils.ToFormat
import com.example.moviesuikit.cards.CustomCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenChore(email: String, chores: AssignedChoreRespondD) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = email) },
                navigationIcon = {
                    IconButton(onClick = { /* Handle navigation icon click */ }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Handle action item click */ }) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                    }
                    IconButton(onClick = { /* Handle action item click */ }) {
                        Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings")
                    }
                    UserImageIcon(imageResourceId = R.drawable.google__g__logo)
                }
            )
        }
    ) {
        TabLayoutScreen(chores)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabLayoutScreen(chores: AssignedChoreRespondD) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabs = arrayOf("Chores", "Done")
    Column(Modifier.padding(top = 100.dp)) {
        TabRow(
            selectedTabIndex = selectedTabIndex
        ) {
            Tab(
                selected = selectedTabIndex == 0,
                onClick = { selectedTabIndex = 0 },
                unselectedContentColor = Color.Black,
                selectedContentColor = Color.Black,
                text = {
                    Text(
                        text = tabs[0]
                    )
                }
            )
            Tab(
                selected = selectedTabIndex == 1,
                onClick = { selectedTabIndex = 1 },
                unselectedContentColor = Color.Black,
                selectedContentColor = Color.Black,
                text = {
                    Text(
                        text = tabs[1]
                    )
                }
            )
        }

        when (selectedTabIndex) {
            0 -> BuildBody(chores)
            1 -> DoneChoresTabContent()
        }
    }
}


@Composable
fun DoneChoresTabContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "hola2", style = MaterialTheme.typography.headlineSmall)
    }
}


@Composable
fun UserImageIcon(imageResourceId: Int, modifier: Modifier = Modifier) {
    IconButton(onClick = { /* Handle user image click */ }, modifier = modifier) {
        Icon(
            painter = painterResource(id = imageResourceId),
            contentDescription = "User Image",
            tint = Color.Black // You can adjust the tint color as needed
        )
    }
}

@Composable
private fun BuildBody(chores: AssignedChoreRespondD) {
    var indexSchedules = 0
    var schedule = ScheduleRespondD()
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(top = 50.dp, start = 8.dp, end = 8.dp)
    ) {
        items(chores.listOfChore) { choreItem ->
            BuildContent(choreItem, chores.listSchedule[indexSchedules])
            indexSchedules++
        }
    }
}

@Composable
private fun BuildContent(listOfChore: ChoreRespondD, scheduleRespondD: ScheduleRespondD) {
    scheduleRespondD.scheduleDate?.let {
        scheduleRespondD.scheduleDate.ToFormat()?.let { it1 ->
            CustomCard.BuildCardChore(
                title = listOfChore.choreName,
                date = it1
            )
        }
    }
}

@Composable
fun BuildBody(email: String) {
    Button(onClick = { }) {
        Text(text = email)
    }
}


