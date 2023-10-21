package com.example.mydecompose.list

import com.arkivanov.decompose.ComponentContext

class DefaultListComponent(
    componentContext: ComponentContext,
    private val onNextClickParam: (id: Int) -> Unit,
) : ListComponent {
    override fun onNextClick(id: Int) {
        onNextClickParam(id)
    }
}