package com.revature.runbuddy.presentation.core

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.ivianuu.contributer.conductor.HasControllerInjector
import com.revature.runbuddy.presentation.core.di.ActivityComponentBuilder
import com.revature.runbuddy.presentation.core.di.HasActivitySubcomponentBuilders
import dagger.android.DispatchingAndroidInjector
import io.reactivex.exceptions.Exceptions
import javax.inject.Inject

abstract class BaseActivity: AppCompatActivity(), HasControllerInjector {

    protected  var router: Router? = null

    @Inject
    lateinit var controllerInjector:DispatchingAndroidInjector<Controller>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreating(savedInstanceState)
    }
    protected open fun onCreating(savedInstanceState: Bundle?){
        injectDependencies()
    }
    private fun injectDependencies(){

    }

    override fun controllerInjector(): DispatchingAndroidInjector<Controller> {
        return controllerInjector
    }
    protected abstract fun prepareControllerComponent(
        subComponentBuilderHost: HasActivitySubcomponentBuilders)
    : ActivityComponentBuilder<*,*>

    protected fun setupRouter(container:ViewGroup,savedInstanceState:Bundle?){
        router = Conductor.attachRouter(this,container,savedInstanceState)
    }
    protected fun setupRootController(controllerClass : Class<Controller>){
        router?.let {
            if(!it.hasRootController()){
                try {
                    it.setRoot(RouterTransaction.with(controllerClass.newInstance()))
                } catch ( e :Exception){
                    throw Exceptions.propagate(e)
                }
            }
        }
    }
    protected fun setupRootController(controller: Controller){
        router?.let {
            if(!it.hasRootController())
                it.setRoot(RouterTransaction.with(controller))
        }
    }
    protected fun pushController(controller:Controller) {
        router?.pushController(RouterTransaction.with(controller))
    }

    override fun onBackPressed() {
        router?.let {
            if(it.handleBack())
                return
        }
        super.onBackPressed()
    }
}