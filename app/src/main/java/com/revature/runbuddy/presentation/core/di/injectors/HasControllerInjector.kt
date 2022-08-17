package com.revature.runbuddy.presentation.core.di.injectors

import com.bluelinelabs.conductor.Controller
import dagger.android.DispatchingAndroidInjector

interface HasControllerInjector {
    fun controllerInjector():DispatchingAndroidInjector<Controller>
}