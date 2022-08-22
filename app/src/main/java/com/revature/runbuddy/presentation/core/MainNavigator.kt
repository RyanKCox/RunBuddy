package com.revature.runbuddy.presentation.core

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import com.revature.runbuddy.MainActivity
import com.revature.runbuddy.presentation.core.conductor.routerTransaction
import com.revature.runbuddy.presentation.core.di.scope.PerActivity
import com.revature.runbuddy.presentation.mainmenu.MainMenuController
import com.revature.runbuddy.presentation.title.TitleController
import javax.inject.Inject

enum class NavigationAction{
    Title,
    MainMenu
}

interface Navigator{

    fun navigateTo(
        navigationAction: NavigationAction?,
        action:String="",
        options:String="")
    fun backFromChild()
}
@PerActivity
class MainNavigator @Inject constructor(
    val activity:AppCompatActivity,
    val context: Context
) : Navigator {

    //Casting of context not working

    private fun getRouter():Router? = (activity as MainActivity).mainControllerChildRouter

    private fun push(
        newController: Controller,
        changeHandler: ControllerChangeHandler = HorizontalChangeHandler(),
        tag: String = newController::class.java.simpleName
    ){
        val (controllerToBePushed, tagToBeUsed) =
            Pair(newController,tag)

        val backStack = getRouter()?.backstack
        val newBackStack = backStack?.filterIndexed{ index, transaction->
            ((index>=1 && transaction.tag() == tagToBeUsed)
                    || (backStack.size == 1 && transaction.tag() == tagToBeUsed))
                .not()
        }?.toMutableList()
        newBackStack?.let {
            if(it.size > 1 && it[0].tag() == it[1].tag()){
                it.removeAt(1)
            }
        }
        newBackStack?.add(routerTransaction(controllerToBePushed,changeHandler,tagToBeUsed))
        newBackStack?.let { getRouter()?.setBackstack(it,changeHandler) }
    }


    override fun navigateTo(navigationAction: NavigationAction?, action: String, options: String) {
        when(navigationAction){
            NavigationAction.Title -> title()
            NavigationAction.MainMenu -> mainMenu()
            else -> TODO()
        }
    }
    private fun title() = push(TitleController())
    private fun mainMenu() = push(MainMenuController())

    override fun backFromChild() {
        TODO("Not yet implemented")
    }
}