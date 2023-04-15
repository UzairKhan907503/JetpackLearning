package com.example.jetpacklearning.ui.homescreen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpacklearning.R
import com.example.jetpacklearning.ui.theme.*

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            GreetingSection()
            ChipSection(chips = listOf("Sweet sleep", "Insomnia", "Depression"))
            CurrentMeditation()
            FeatureSection(
                features = listOf(
                    Feature(
                        title = "Sleep meditation",
                        iconId = R.drawable.ic_headphone,
                        color = BlueViolet1
                    ),
                    Feature(
                        title = "Tips for sleeping",
                        iconId = R.drawable.ic_videocam,
                        color = LightGreen1
                    ),
                    Feature(
                        title = "Night Island",
                        iconId = R.drawable.ic_videocam,
                        color = OrangeYellow1
                    ),
                    Feature(
                        title = "Calming Sounds",
                        iconId = R.drawable.ic_videocam,
                        color = Beige1
                    )
                )
            )
        }
        BottomNavigationSection(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun GreetingSection(
    name: String = "Uzair Khan"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = "Good Morning, $name",
                style = MaterialTheme.typography.h2
            )

            Text(
                text = "We wish you have a good day!",
                style = MaterialTheme.typography.body1
            )

        }
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun ChipSection(
    chips: List<String>
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }

    LazyRow {
        items(count = chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ) {
                Text(text = chips[it], color = TextWhite)
            }
        }
    }
}

@Composable
fun CurrentMeditation(
    color: Color = LightRed
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = "Daily Thought",
                style = MaterialTheme.typography.h2
            )
            Text(
                text = "Meditation - 3-10 min",
                style = MaterialTheme.typography.body1,
                color = TextWhite
            )
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(12.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
fun FeatureSection(features: List<Feature>) {
    Text(
        text = "Feature",
        style = MaterialTheme.typography.h1,
        modifier = Modifier.padding(15.dp)
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(features.size) {
            FeatureItem(feature = features[it])
        }
    }
}

@Composable
fun FeatureItem(feature: Feature) {
    Box(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.color)
            .padding(15.dp)
    ) {
        Text(
            text = feature.title,
            style = MaterialTheme.typography.h1,
            lineHeight = 26.sp,
            modifier = Modifier.align(Alignment.TopStart)
        )
        Icon(
            painter = painterResource(id = feature.iconId),
            contentDescription = feature.title,
            tint = Color.White,
            modifier = Modifier.align(Alignment.BottomStart)
        )
        Text(text = "Start",
            color = TextWhite,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .clickable {
                    // handle click
                }
                .align(Alignment.BottomEnd)
                .clip(RoundedCornerShape(10.dp))
                .background(ButtonBlue)
                .padding(vertical = 6.dp, horizontal = 15.dp)
        )
    }
}

@Composable
fun BottomNavigationSection(modifier: Modifier = Modifier) {
    val items = listOf(
        BottomMenuContent(R.drawable.ic_home, "Home"),
        BottomMenuContent(R.drawable.ic_bubble, "Meditate"),
        BottomMenuContent(R.drawable.ic_moon, "Sleep"),
        BottomMenuContent(R.drawable.ic_music, "Music"),
        BottomMenuContent(R.drawable.ic_profile, "Profile"),
    )
    var bottomSelectionState by remember {
        mutableStateOf(0)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp),
    ) {
        items.forEachIndexed { index, item ->
            BottomItem(
                color = if(index == bottomSelectionState) ButtonBlue else Color.Transparent,
                iconColor = if(index == bottomSelectionState) TextWhite else AquaBlue,
                icon = item.icon,
                title = item.title,
                position = index
            ) {
                bottomSelectionState = it
            }
        }
    }
}

@Composable
fun BottomItem(
    color: Color,
    iconColor: Color,
    @DrawableRes icon: Int,
    title: String,
    position: Int,
    onClicked: (Int) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clickable {
                onClicked(position)
            }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(color)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = title,
                tint = iconColor,
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.Center)
            )
        }
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            text = title,
            style = MaterialTheme.typography.body2,
            color = iconColor
        )
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MeditationUIYouTubeTheme {
        BottomItem(
            color = BlueViolet1,
            icon = R.drawable.ic_home,
            title = "Home",
            iconColor = TextWhite,
            position = 0,
            onClicked = {}
        )
    }
}