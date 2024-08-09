package com.example.buildapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buildapp.ui.theme.BuildAppTheme


@Composable
fun BuildAppStart(
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
)
{
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE6E6FA)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = stringResource(R.string.MaintText),
            style = MaterialTheme.typography.h3,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, start = 85.dp, bottom = 50.dp)

        )
        Image(
            painter = painterResource(R.drawable.museumlogo), //adds the chef Icon
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
        )
        BuildAppButton(
            onClick = onNextButtonClicked,
            modifier = Modifier
                .padding(top =  20.dp)

        )

    }

}

@Composable
fun BuildAppButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Button(
        onClick = onClick,
        modifier = modifier
            .widthIn(min = 250.dp)
    ) {
        Text(text = "Start")
    }


}


@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun BuildAppPreview()
{
 BuildAppTheme {
    BuildAppStart(
        onNextButtonClicked ={},
        modifier = Modifier
            .fillMaxSize()
    )
 }
}