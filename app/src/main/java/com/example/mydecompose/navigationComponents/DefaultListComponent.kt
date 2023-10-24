package com.example.mydecompose.navigationComponents

import com.arkivanov.decompose.ComponentContext

class DefaultListComponent(
    componentContext: ComponentContext,
    private val onNextClickParam: (id: Int) -> Unit,
) : ListComponent {
    override fun onNextClick(id: Int) {
        onNextClickParam(id)
    }
}

interface ListComponent {

    fun onNextClick(id: Int)
}