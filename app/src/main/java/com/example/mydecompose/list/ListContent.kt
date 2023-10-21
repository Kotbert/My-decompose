package com.example.mydecompose.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mydecompose.ui.theme.MyDecomposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListContent(component: ListComponent, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Text(text = "Типо список")
        Spacer(modifier = Modifier.size(4.dp))
        Divider(thickness = 1.dp, color = Color.Gray)
        Spacer(modifier = Modifier.size(4.dp))
        repeat(5) {
            Card(modifier = Modifier.padding(vertical = 2.dp), onClick = {
                component.onNextClick(it)
            }) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Name $it")
                    Icon(imageVector = Icons.Rounded.ArrowForward, contentDescription = null)
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewListContent() {
    MyDecomposeTheme {}
}