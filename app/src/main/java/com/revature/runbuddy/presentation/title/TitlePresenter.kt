package com.revature.runbuddy.presentation.title

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import com.revature.runbuddy.presentation.core.NavigationAction
import com.revature.runbuddy.presentation.core.Navigator
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class TitlePresenter @Inject constructor (
    val nav:Navigator
):MviBasePresenter<TitleView,TitleViewState>(){
    override fun bindIntents() {

        val enterIntent = intent { it.enterIntent() }
            .doOnNext{
                nav.navigateTo(NavigationAction.MainMenu)
            }
            .ofType(TitleViewState::class.java)

        val data =Observable.just(TitleViewState.DisplayScreen)
            .ofType(TitleViewState::class.java)

        val viewState = data
            .mergeWith(enterIntent)
            .observeOn(AndroidSchedulers.mainThread())

        subscribeViewState(viewState){view,state->view.render(state)}
    }

}

interface TitleView:MvpView{
    fun enterIntent():Observable<Unit>
    fun render(state:TitleViewState)
}
sealed class TitleViewState{
    object Loading:TitleViewState()
    object DisplayScreen:TitleViewState()
}