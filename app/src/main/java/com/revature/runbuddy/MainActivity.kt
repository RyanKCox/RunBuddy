package com.revature.runbuddy

import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import com.bluelinelabs.conductor.Router
import com.revature.runbuddy.databinding.ActivityMainBinding
import com.revature.runbuddy.presentation.core.BaseActivity
import com.revature.runbuddy.presentation.core.di.ActivityComponentBuilder
import com.revature.runbuddy.presentation.core.di.HasActivitySubcomponentBuilders
import com.revature.runbuddy.presentation.core.di.components.MainActivityComponent
import com.revature.runbuddy.presentation.title.TitleController

class MainActivity : BaseActivity() {

    private lateinit var container:ViewGroup

    val mainControllerChildRouter: Router?
        get() {
            val mainController = router!!.getControllerWithTag(
                TitleController::class.java.simpleName)
            return if(mainController != null
                && mainController.childRouters.size > 0
                && mainController.childRouters[0]!= null){
                mainController.childRouters[0]
            } else null
        }

    override fun onCreating(savedInstanceState: Bundle?) {
        super.onCreating(savedInstanceState)

        Log.d("MainActivity","onCreating - Inflate")
        val bindings = ActivityMainBinding.inflate(layoutInflater)
        Log.d("MainActivity","SetContent")
        setContentView(bindings.root)
        Log.d("MainActivity","Assign Container")
        container = bindings.controllerContainer


        Log.d("MainActivity","Router Setup")
        setupRouter(container,savedInstanceState)
        Log.d("MainActivity","RootController Setup")
        setupRootController(TitleController())
    }

    override fun prepareControllerComponent(subComponentBuilderHost: HasActivitySubcomponentBuilders): ActivityComponentBuilder<*, *> {
        return subComponentBuilderHost.getActivityComponentBuilder(
            MainActivityComponent.Builder::class.java
        )
    }
}