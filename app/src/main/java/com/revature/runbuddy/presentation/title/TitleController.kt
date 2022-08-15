package com.revature.runbuddy.presentation.title

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.mosby3.MviController
import io.reactivex.Observable

class TitleController :MviController<TitleView,TitlePresenter>(),TitleView{
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup,
        savedViewState: Bundle?
    ): View {
        TODO("Not yet implemented")
    }

    override fun createPresenter(): TitlePresenter {
        TODO("Not yet implemented")
    }

    override fun initialIntent(): Observable<Unit> {
        TODO("Not yet implemented")
    }

    override fun enterIntent(): Observable<Unit> {
        TODO("Not yet implemented")
    }

    override fun render() {
        TODO("Not yet implemented")
    }

}