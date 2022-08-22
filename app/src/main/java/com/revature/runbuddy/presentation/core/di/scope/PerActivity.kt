package com.revature.runbuddy.presentation.core.di.scope

import android.app.Activity
import javax.inject.Scope
import kotlin.reflect.KClass

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity()