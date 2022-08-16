package com.revature.runbuddy.presentation.core.di

interface HasActivitySubcomponentBuilders {
    fun <T : ActivityComponentBuilder<*, *>?> getActivityComponentBuilder(
        activityComponentBuilderClass: Class<T>?
    ): T
}