package com.revature.runbuddy.presentation.core.di.components

import com.revature.runbuddy.MainActivity
//import com.revature.runbuddy.presentation.core.di.modules.ControllerBindingModule
import com.revature.runbuddy.presentation.core.di.modules.ControllerInjectionModule
import com.revature.runbuddy.presentation.core.di.modules.MainActivityModule
import com.revature.runbuddy.presentation.core.di.scope.ActivityScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [
    MainActivityModule::class,
//    ControllerBindingModule::class,
    ControllerInjectionModule::class
])
@ActivityScope
interface MainActivityComponent :AndroidInjector<MainActivity>{
    @Subcomponent.Factory
    interface Factory: AndroidInjector.Factory<MainActivity>
}