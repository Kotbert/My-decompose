package com.example.mydecompose.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mydecompose.ui.theme.MyDecomposeTheme

@Composable
fun DetailsContent(component: DetailsComponent) {
    val count by component.count.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "${component.id} счетчик: $count")
        Spacer(modifier = Modifier.size(8.dp))
        Button(onClick = component::increaseCount) {
            Text(text = "+")
        }
    }
}

@Preview
@Composable
private fun PreviewDetailsContent() {
    MyDecomposeTheme {}
}