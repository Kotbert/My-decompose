package com.example.mydecompose.detail

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class DefaultDetailsComponent(
    componentContext: ComponentContext, onFinished: () -> Unit, override val id: Int
) : ComponentContext by componentContext, DetailsComponent {
    override var count: MutableStateFlow<Int> = MutableStateFlow(0)
        private set

    override fun increaseCount() {
        val value = count.value
        count.update { value + 1 }
    }

}