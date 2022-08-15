package com.revature.runbuddy.presentation.title

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import com.revature.runbuddy.presentation.core.Navigator
import io.reactivex.Observable

class TitlePresenter(
    private val nav:Navigator
):MviBasePresenter<TitleView,TitleViewState>{

}

interface TitleView:MvpView{
    fun initialIntent():Observable<Unit>
    fun enterIntent():Observable<Unit>
    fun render()
}
sealed class TitleViewState{
    object Loading:TitleViewState()
    object DisplayScreen:TitleViewState()
}