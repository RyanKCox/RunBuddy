package com.revature.runbuddy

import android.os.Bundle
import com.bluelinelabs.conductor.Router
import com.revature.runbuddy.presentation.core.BaseActivity
import com.revature.runbuddy.presentation.title.TitleController

class MainActivity : BaseActivity() {

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}