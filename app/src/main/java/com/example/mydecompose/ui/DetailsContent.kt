package com.example.mydecompose.ui

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
import com.example.mydecompose.navigationComponents.DetailsComponent
import com.example.mydecompose.ui.theme.MyDecomposeTheme
import com.example.mydecompose.ui.data.DetailsContentUiData

@Composable
fun DetailsContent(component: DetailsComponent) {
    val count by component.count.collectAsState()
    val uiData = DetailsContentUiData(
        id = component.id,
        count = count
    )

    CompDetailsContent(
        uiData = uiData,
        increaseCount = { component.increaseCount() }
    )
}

@Composable
private fun CompDetailsContent(
    uiData: DetailsContentUiData,
    increaseCount: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "${uiData.id} счетчик: ${uiData.count}")
        Spacer(modifier = Modifier.size(8.dp))
        Button(onClick = increaseCount) {
            Text(text = "+")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewDetailsContent() {
    MyDecomposeTheme {
        CompDetailsContent(
            uiData = DetailsContentUiData(id = 1, count = 0),
            increaseCount = { /*TODO*/ })
    }
}