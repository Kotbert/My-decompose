package com.example.mydecompose.root

import android.annotation.SuppressLint
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.example.mydecompose.detail.DefaultDetailsComponent
import com.example.mydecompose.detail.DetailsComponent
import com.example.mydecompose.list.DefaultListComponent
import com.example.mydecompose.list.ListComponent
import com.example.mydecompose.root.RootComponent.Child.DetailsChild
import com.example.mydecompose.root.RootComponent.Child.ListChild
import kotlinx.parcelize.Parcelize

class RealRootComponent(componentContext: ComponentContext) : RootComponent,
    ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    override val stack: Value<ChildStack<*, RootComponent.Child>> = childStack(
        source = navigation,
        initialConfiguration = Config.List, // The initial child component is List
        handleBackButton = true, // Automatically pop from the stack on back button presses
        childFactory = ::child,
    )

    private fun child(config: Config, componentContext: ComponentContext): RootComponent.Child =
        when (config) {
            is Config.List -> ListChild(listComponent(componentContext))
            is Config.Details -> DetailsChild(
                detailsComponent(
                    componentContext, config
                )
            )
        }

    private fun listComponent(componentContext: ComponentContext): ListComponent =
        DefaultListComponent(
            componentContext = componentContext,
            onNextClickParam = { item ->
                navigation.push(Config.Details(item = item))
            },
        )

    private fun detailsComponent(
        componentContext: ComponentContext, config: Config.Details
    ): DetailsComponent = DefaultDetailsComponent(
        componentContext = componentContext,
        id = config.item,
        onFinished = navigation::pop,
    )

    override fun onBackClicked(toIndex: Int) {
        navigation.popTo(index = toIndex)
    }

    @Parcelize // The `kotlin-parcelize` plugin must be applied if you are targeting Android
    private sealed interface Config : Parcelable {
        @SuppressLint("ParcelCreator")
        object List : Config

        @SuppressLint("ParcelCreator")
        data class Details(val item: Int) : Config
    }

}