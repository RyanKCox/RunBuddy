package com.revature.runbuddy.presentation

import android.app.Application
import android.content.Context
import com.revature.runbuddy.MainActivity
import com.revature.runbuddy.presentation.core.di.components.*
import dagger.android.*
import javax.inject.Inject

class RunBuddyApp : Application(), HasAndroidInjector {

    companion object{
        fun get(context: Context):RunBuddyApp{
            return context.applicationContext as RunBuddyApp
        }
    }
    @Inject
    lateinit var injector:DispatchingAndroidInjector<Any>


    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .context(this)
            .build()
            .inject(this)
    }

    fun get(context: Context):RunBuddyApp{
        return context.applicationContext as RunBuddyApp
    }

    override fun androidInjector(): AndroidInjector<Any> =injector


}