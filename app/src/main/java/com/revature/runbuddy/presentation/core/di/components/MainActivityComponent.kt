package com.revature.runbuddy.presentation.core.di.components

import android.os.Build
import com.revature.runbuddy.MainActivity
import com.revature.runbuddy.presentation.core.di.ActivityComponent
import com.revature.runbuddy.presentation.core.di.ActivityComponentBuilder
import com.revature.runbuddy.presentation.core.di.modules.MainActivityBindingModule
import com.revature.runbuddy.presentation.core.di.modules.MainActivityModule
import com.revature.runbuddy.presentation.core.di.scope.ActivityScope
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules =[
    MainActivityBindingModule::class,
    MainActivityModule::class
])interface MainActivityComponent : ActivityComponent<MainActivity>{
    @Subcomponent.Builder
    interface Builder : ActivityComponentBuilder<MainActivityComponent,Builder>{
//        @BindsInstance fun actionBarManager
    }
}