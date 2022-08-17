package com.revature.runbuddy.presentation.core.di

import com.bluelinelabs.conductor.Controller
import com.revature.runbuddy.presentation.core.di.injectors.HasControllerInjector

import dagger.internal.Preconditions

class ConductorInjection {
    companion object{
        fun inject(controller: Controller){
            Preconditions.checkNotNull(controller,"controller")
            val hasInjector = findControllerInjector(controller)
            val controllerInjector = hasInjector.controllerInjector()
            Preconditions.checkNotNull(
                controllerInjector,
                "${controller::class.simpleName}.controllerInjector() null",
                hasInjector.javaClass.canonicalName
            )
            controllerInjector.inject(controller)


        }
        private fun findControllerInjector(controller: Controller): HasControllerInjector {
            var superController:Controller? = controller
            do {
                superController = superController?.parentController
                if(superController == null){
                    val activity = controller.activity
                    if(activity is HasControllerInjector)
                        return  activity
                    if(activity!!.application is HasControllerInjector)
                        return activity.application as HasControllerInjector
                    throw IllegalArgumentException("no injector found")
                }
            } while (superController !is HasControllerInjector)
            return superController
        }
    }
}