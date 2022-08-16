package com.revature.runbuddy.presentation.core.di.modules

import com.ivianuu.contributer.conductor.ControllerKey
import com.revature.runbuddy.presentation.core.di.scope.PerController
import com.revature.runbuddy.presentation.title.TitleController
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
interface MainActivityBindingModule{

    @ControllerKey(TitleController::class)
    @PerController(TitleController::class)
    @ContributesAndroidInjector
    fun bindTitleController(): TitleController
}