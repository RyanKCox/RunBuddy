package com.revature.runbuddy.presentation.core.di.modules

import com.revature.runbuddy.presentation.core.MainNavigator
import com.revature.runbuddy.presentation.core.Navigator
import dagger.Binds
import dagger.Module

@Module
interface NavModule{
    @Binds
    fun bindNav(nav:MainNavigator):Navigator
}