package com.revature.runbuddy.presentation.mainmenu

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class MainMenuPresenter @Inject constructor() :MviBasePresenter<MainMenuView,MainMenuViewState>(){
    override fun bindIntents() {

        val data = Observable.just(MainMenuViewState.Progress(0,5))
            .delay(1,TimeUnit.SECONDS)
            .doOnSubscribe { MainMenuViewState.Loading }
            .ofType(MainMenuViewState::class.java)

        val viewState = data
            .observeOn(AndroidSchedulers.mainThread())

        subscribeViewState(viewState){view,state->view.render(state)}
    }

}
interface MainMenuView:MvpView{
    fun startRunIntent():Observable<Int>
    fun render(state:MainMenuViewState)

}
sealed class MainMenuViewState{
    data class Progress(
        val currentRun:Int,
        val allRuns:Int
    ):MainMenuViewState()
    object Loading:MainMenuViewState()
}