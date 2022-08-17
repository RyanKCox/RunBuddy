package com.revature.runbuddy.presentation.core.di.components

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.revature.runbuddy.presentation.RunBuddyApp
import com.revature.runbuddy.presentation.core.di.modules.ActivityBindingModule
import com.revature.runbuddy.presentation.core.di.modules.MainActivityModule
import com.revature.runbuddy.presentation.core.di.modules.NavModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ActivityBindingModule::class,
    AndroidSupportInjectionModule::class,
    NavModule::class
])
internal interface AppComponent:AndroidInjector<RunBuddyApp>{
    @Component.Builder
    interface Builder{
        @BindsInstance fun context(context: Context):Builder
        fun build():AppComponent
    }
}