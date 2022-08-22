package com.revature.runbuddy.presentation.core

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.revature.runbuddy.MainActivity
import com.revature.runbuddy.presentation.RunBuddyApp
import com.revature.runbuddy.presentation.core.di.components.DaggerAppComponent
import com.revature.runbuddy.presentation.core.di.components.activity.ActivityComponent
import com.revature.runbuddy.presentation.core.di.injectors.HasControllerInjector
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import io.reactivex.exceptions.Exceptions
import javax.inject.Inject

abstract class BaseActivity: AppCompatActivity()/*, HasControllerInjector*/ {

    protected  var router: Router? = null
//    @Inject
//    lateinit var controllerInjector: DispatchingAndroidInjector<Controller>

//    override fun controllerInjector() = controllerInjector

    private lateinit var activityComponent:ActivityComponent

    fun getActivityComponent()= activityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
//        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        onCreating(savedInstanceState)
    }
    protected open fun onCreating(savedInstanceState: Bundle?) {
        injectDependencies()
    }
    private fun injectDependencies(){

//        val component = prepareControllerComponent(RunBuddyApp.get(this))
//            .context(this)
//            .activity(this)
//            .build()
//        component.injectMembers(this)
        activityComponent = (application as RunBuddyApp).getAppComponent()
            .getActivityComponentFactory()
            .create(this,this)
    }

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