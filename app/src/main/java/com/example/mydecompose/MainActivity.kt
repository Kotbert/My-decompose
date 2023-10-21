package com.example.mydecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import com.example.mydecompose.root.RealRootComponent
import com.example.mydecompose.root.RootUi
import com.example.mydecompose.ui.theme.MyDecomposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = RealRootComponent(defaultComponentContext())

        setContent {
            MyDecomposeTheme {
                RootUi(component = root)
            }
        }
    }
}