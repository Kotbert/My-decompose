package com.example.mydecompose.detail

import kotlinx.coroutines.flow.StateFlow

interface DetailsComponent {
    val id: Int
    val count: StateFlow<Int>

    fun increaseCount()
}