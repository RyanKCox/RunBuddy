package com.revature.runbuddy.presentation.core.di.modules

import com.bluelinelabs.conductor.Controller
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.Multibinds

@Module
abstract class ControllerInjectionModule private constructor(){
    @Multibinds abstract fun controllerInjectionFactories():
            Map<Class<out Controller>,
                AndroidInjector.Factory<out Controller>>
    @Multibinds abstract fun controllerInjectionFactoriesWIthStringKeys():
            Map<String,
                AndroidInjector.Factory<out Controller>>
}