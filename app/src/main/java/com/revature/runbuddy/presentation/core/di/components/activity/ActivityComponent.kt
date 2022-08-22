package com.revature.runbuddy.presentation.core.di.components.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.revature.runbuddy.presentation.core.di.modules.NavModule
import com.revature.runbuddy.presentation.core.di.scope.PerActivity
import com.revature.runbuddy.presentation.mainmenu.MainMenuController
import com.revature.runbuddy.presentation.title.TitleController
import dagger.BindsInstance
import dagger.Subcomponent

@PerActivity
@Subcomponent(modules = [
    NavModule::class
])
interface ActivityComponent{
    @Subcomponent.Factory
    interface Factory{
        fun create(
            @BindsInstance activity: AppCompatActivity,
            @BindsInstance context: Context
        ): ActivityComponent
    }

    fun inject(controller:TitleController)
    fun inject(controller:MainMenuController)
}