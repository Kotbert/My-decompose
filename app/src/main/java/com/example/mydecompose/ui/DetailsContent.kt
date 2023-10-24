package com.example.mydecompose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mydecompose.navigationComponents.DetailsComponent
import com.example.mydecompose.ui.data.DetailsContentUiData
import com.example.mydecompose.ui.theme.MyDecomposeTheme

@Composable
fun DetailsContent(component: DetailsComponent) {
    val count by component.count.collectAsState()
    val uiData = DetailsContentUiData(
        count = count
    )

    CompDetailsContent(
        uiData = uiData,
    )
}

@Composable
private fun CompDetailsContent(
    uiData: DetailsContentUiData, //Просто оставил
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                text = "Следующий экран",
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.size(16.dp))
        }
        items(5) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                var count by remember { mutableStateOf(0) }
                Text(text = "Старый счетчик ${it + 1}: $count")
                Spacer(modifier = Modifier.size(8.dp))
                Button(onClick = { count++ }) {
                    Text(text = "+")
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewDetailsContent() {
    MyDecomposeTheme {
        CompDetailsContent(uiData = DetailsContentUiData(count = 0))
    }
}