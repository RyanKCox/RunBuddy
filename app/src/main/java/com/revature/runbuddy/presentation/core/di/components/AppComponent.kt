package com.revature.runbuddy.presentation.core.di.components

import com.revature.runbuddy.presentation.core.di.components.activity.ActivityComponent

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent{
    fun getActivityComponentFactory():ActivityComponent.Factory
}