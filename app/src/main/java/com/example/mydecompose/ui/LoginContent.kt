package com.example.mydecompose.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mydecompose.navigationComponents.ListComponent

data class LoginScreenUiData(
    val loginValue: String,
    val passwordValue: String,
)

@Composable
fun LoginContent(component: ListComponent) {
    val uiState by component.uiState.collectAsState()
    CompLoginContent(uiData = uiState.loginData,
        onLoginChange = { component.changeLogin(it) },
        onPasswordChange = { component.changePassword(it) },
        onNextClick = { component.onNextClick() })
}

@Composable
private fun CompLoginContent(
    uiData: LoginScreenUiData,
    onNextClick: () -> Unit,
    onLoginChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 8.dp, start = 8.dp, end = 8.dp, bottom = 200.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.size(24.dp))
            Text(text = "Логин", fontSize = 24.sp)
            Spacer(modifier = Modifier.size(12.dp))
            OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                value = uiData.loginValue,
                onValueChange = onLoginChange,
                label = { Text(text = "Login") })
            Spacer(modifier = Modifier.size(16.dp))
            OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                value = uiData.passwordValue,
                onValueChange = onPasswordChange,
                label = { Text(text = "Password") })
            Spacer(modifier = Modifier.size(16.dp))
            Button(
                enabled = uiData.loginValue.length >= 6 && uiData.passwordValue.length >= 6,
                onClick = onNextClick
            ) {
                Text(text = "Вход")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLoginContent() {
    CompLoginContent(uiData = LoginScreenUiData(loginValue = "", passwordValue = ""),
        onLoginChange = {},
        onPasswordChange = {},
        onNextClick = {})
}