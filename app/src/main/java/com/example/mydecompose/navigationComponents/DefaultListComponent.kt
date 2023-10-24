package com.example.mydecompose.navigationComponents

import com.arkivanov.decompose.ComponentContext
import com.example.mydecompose.ui.LoginScreenUiData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DefaultListComponent(
    componentContext: ComponentContext,
    private val onNextClickParam: () -> Unit,
) : ListComponent {

    private val _uiState = MutableStateFlow(ListComponent.UiState())
    override val uiState: StateFlow<ListComponent.UiState>
        get() = _uiState.asStateFlow()

    override fun changeLogin(text: String) {
        _uiState.update {
            it.copy(loginData = LoginScreenUiData(loginValue = text, it.loginData.passwordValue))
        }
    }

    override fun changePassword(text: String) {
        _uiState.update {
            it.copy(loginData = LoginScreenUiData(it.loginData.loginValue, text))
        }
    }


    override fun onNextClick() {
        onNextClickParam()
    }
}

interface ListComponent {
    data class UiState(val loginData: LoginScreenUiData = LoginScreenUiData("", ""))

    val uiState: StateFlow<UiState>

    fun changeLogin(text: String)
    fun changePassword(text: String)
    fun onNextClick()
}