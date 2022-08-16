package com.revature.runbuddy.presentation.core.di.modules

import com.revature.runbuddy.presentation.core.MainNavigator
import com.revature.runbuddy.presentation.core.Navigator
import com.revature.runbuddy.presentation.core.di.scope.ActivityScope
import dagger.Binds
import dagger.Module

@Module
abstract class MainActivityModule {
    @Binds
    @ActivityScope
    abstract fun providesMainNavigator(nav:MainNavigator):Navigator

}