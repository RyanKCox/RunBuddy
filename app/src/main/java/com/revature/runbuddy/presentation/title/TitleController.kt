package com.revature.runbuddy.presentation.title

import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.revature.runbuddy.R
import com.revature.runbuddy.databinding.ControllerTitleScreenBinding
import com.revature.runbuddy.presentation.core.conductor.MviBaseController
import io.reactivex.Observable

class TitleController : MviBaseController<TitleView, TitlePresenter>(),TitleView{
    private lateinit var text:TextView
    private lateinit var button:Button

    override fun onViewBound(view: View) {
        setup(view)
    }


    private fun setup(view:View){
        val binding =ControllerTitleScreenBinding.bind(view)
        text = binding.textTitle
        button = binding.buttonTitle
    }

    override fun initialIntent(): Observable<Unit> {
        TODO("Not yet implemented")
    }

    override fun enterIntent(): Observable<Unit> {
        TODO("Not yet implemented")
    }

    override fun render(state: TitleViewState) {
        Log.d("TitleController","Render")
        when(state){
            is TitleViewState.DisplayScreen->{
                Log.d("TitleController","Render Display")
                text.visibility = View.VISIBLE
                text.text = "Hello!"
                button.visibility = View.VISIBLE
                button.text = "Button!"

            }
            is TitleViewState.Loading->{
                Log.d("TitleController","Render Loading")

            }
        }
    }

    override fun getLayoutId() = R.layout.controller_title_screen


}