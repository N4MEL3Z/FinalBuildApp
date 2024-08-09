package com.example.buildapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buildapp.Data.DataSource
import com.example.buildapp.Data.Data2
import com.example.buildapp.model.Detail
import com.example.buildapp.model.Topic
import com.example.buildapp.ui.theme.BuildAppTheme



@Composable
fun TopicGrid(modifier: Modifier = Modifier
) {

    LazyVerticalGrid/*Scrollable*/(
        columns = GridCells.Fixed(1),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        modifier = modifier




    ) {
        val topics = DataSource.topics
        val details = Data2.details


        val combinedList = details.zip(topics)/*This Allows details and topic combine into pair*/       
        items(combinedList) { (topic,   detail) ->
            TopicCard(detail,topic)
        }
    }
}
@Composable
fun TopicCard(detail: Topic, topic: Detail, modifier: Modifier = Modifier) {
        Card {

            Row {

                Box {
                    Image/*Image Loader*/(
                        painter = painterResource(id = detail.imageRes),
                        contentDescription = null,
                        modifier = modifier
                            .size(width = 68.dp, height = 100.dp)
                            .aspectRatio(1f),
                        contentScale = ContentScale.Crop
                    )
                }

                Column {
                    Text/*Text Loader*/(
                        text = stringResource(id = detail.name1),
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(
                            start = dimensionResource(R.dimen.padding_medium),
                            top = dimensionResource(R.dimen.padding_medium),
                            end = dimensionResource(R.dimen.padding_medium),
                            bottom = dimensionResource(R.dimen.padding_small),
                        )

                    )
                    var revealText by remember { mutableStateOf(false) }
                    Button(
                        onClick = { revealText = !revealText },
                        modifier = Modifier
                            .background(Color.Red)
                            .fillMaxWidth()
                    ) {
                        if (!revealText) {
                            Text(text = "View",
                            style =MaterialTheme.typography.body1)
                        } else {
                            Text(text = "Close")

                        }

                    }
                    if (revealText) {
                        Text(text = stringResource(id = topic.name2),
                            modifier = Modifier
                                .padding(16.dp))

                    }

                }
            }
        }


    }

@Preview(showBackground = true)
@Composable
fun TopicCardPreview() {
    BuildAppTheme {
        TopicGrid()
    }
}