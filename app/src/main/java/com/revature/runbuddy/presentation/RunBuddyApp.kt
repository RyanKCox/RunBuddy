package com.revature.runbuddy.presentation

import android.app.Application
import android.content.Context
import com.revature.runbuddy.presentation.core.di.components.AppComponent
import com.revature.runbuddy.presentation.core.di.components.DaggerAppComponent
import dagger.android.*
import javax.inject.Inject

class RunBuddyApp : Application()/*, HasAndroidInjector*/ {

    companion object{
        fun get(context: Context):RunBuddyApp{
            return context.applicationContext as RunBuddyApp
        }
    }
//    @Inject
//    lateinit var injector:DispatchingAndroidInjector<Any>

    private lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.create()
    }
    fun getAppComponent(): AppComponent = appComponent

//    override fun androidInjector(): AndroidInjector<Any> =injector



}