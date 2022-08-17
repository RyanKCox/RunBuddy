package com.revature.runbuddy.presentation.core.di.modules

import com.revature.runbuddy.MainActivity
import com.revature.runbuddy.presentation.core.di.components.MainActivityComponent
import com.revature.runbuddy.presentation.core.di.scope.PerController
import com.revature.runbuddy.presentation.title.TitleController
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [MainActivityComponent::class])
abstract class ActivityBindingModule {
    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    internal abstract fun bindYourAndroidInjectorFactory(factory:MainActivityComponent.Factory):
            AndroidInjector.Factory<*>

    @ClassKey(TitleController::class)
    @PerController(TitleController::class)
    @ContributesAndroidInjector
    internal abstract fun bindTitleController():TitleController
}