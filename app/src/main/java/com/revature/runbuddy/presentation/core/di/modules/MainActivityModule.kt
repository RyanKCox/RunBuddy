package com.revature.runbuddy.presentation.core.di.modules

import com.revature.runbuddy.MainActivity
import com.revature.runbuddy.presentation.core.MainNavigator
import com.revature.runbuddy.presentation.core.Navigator
import com.revature.runbuddy.presentation.core.di.scope.ActivityScope
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule{
    @Provides @ActivityScope fun activityName(activity:MainActivity): String{
        return activity.javaClass.name
    }
}