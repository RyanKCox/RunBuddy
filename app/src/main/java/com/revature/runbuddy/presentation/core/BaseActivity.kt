package com.revature.runbuddy.presentation.core

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import io.reactivex.exceptions.Exceptions
import java.lang.IllegalArgumentException

abstract class BaseActivity: AppCompatActivity() {
    protected  var router: Router? = null

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
        router?.let { it.pushController(RouterTransaction.with(controller)) }
    }

    override fun onBackPressed() {
        router?.let {
            if(it.handleBack())
                return
        }
        super.onBackPressed()
    }

}