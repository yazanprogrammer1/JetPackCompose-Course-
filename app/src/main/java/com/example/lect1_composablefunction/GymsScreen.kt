package com.example.lect1_composablefunction

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lect1_composablefunction.ViewModel.GymsViewModel
import com.example.lect1_composablefunction.ui.theme.Lect1_ComposableFunctionTheme

@Composable
fun GymsScreen() {
//    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
//        listOfGyms.forEach {
//            GymItem(gym = it)
//        }
//   }
    val vm: GymsViewModel = viewModel()
    LazyColumn() {
        items(vm.state) { gym ->
            GymItem(gym = gym) {
                vm.toggleFavouriteState(it)
            }
        }
    }
}

@Composable
fun GymItem(gym: Gym, onClick: (Int) -> Unit) {
    val icon = if (gym.isFavourite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ), colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ), modifier = Modifier.padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            DefaultIcon(
                Icons.Filled.Place,
                Modifier
                    .weight(0.15f)
                    .padding(8.dp),
                "Place icon",
                ColorFilter.tint(Color.Gray)
            )
            GymDetails(gym, Modifier.weight(0.70f))
            DefaultIcon(
                icon,
                Modifier
                    .weight(0.15f)
                    .padding(8.dp),
                "Favourite icon",
                ColorFilter.tint(Color.Red)
            ) {
                onClick(gym.id)
            }
        }
    }
}

@Composable
fun DefaultIcon(
    icon: ImageVector,
    modifier: Modifier,
    contentDescription: String,
    colorFilter: ColorFilter? = null,
    onClick: () -> Unit = {},
) {
    Image(
        imageVector = icon,
        contentDescription = "Favourite icon",
        modifier = modifier.clickable {
            onClick()
        },
        colorFilter = colorFilter
    )
}

@Composable
fun GymDetails(gym: Gym, modifier: Modifier) {
    Column(modifier = modifier) {
        OutlinedCard(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ), border = BorderStroke(1.dp, Color.Red), modifier = Modifier.padding(5.dp)
        ) {
            Text(
                text = gym.name, style = TextStyle(
                    color = Color.Blue,
                    fontSize = 24.sp,
                    fontStyle = FontStyle.Normal,
                    fontFamily = FontFamily.Cursive,
                    textAlign = TextAlign.Center
                ), modifier = Modifier.padding(5.dp)
            )
        }
        Text(
            text = gym.place, modifier = Modifier.padding(5.dp)
        )
    }
}


@Preview(name = "GymScreenItem", showBackground = true)
@Composable
fun _GymScreenPreview() {
    Lect1_ComposableFunctionTheme {
        GymsScreen()
    }
}