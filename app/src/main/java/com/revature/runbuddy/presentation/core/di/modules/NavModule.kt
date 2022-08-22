package com.revature.runbuddy.presentation.core.di.modules

import com.revature.runbuddy.presentation.core.MainNavigator
import com.revature.runbuddy.presentation.core.Navigator
import com.revature.runbuddy.presentation.core.di.scope.PerActivity
import dagger.Binds
import dagger.Module

@Module
abstract class NavModule {
    @PerActivity
    @Binds
    abstract fun bindNavigator(nav:MainNavigator):Navigator
}