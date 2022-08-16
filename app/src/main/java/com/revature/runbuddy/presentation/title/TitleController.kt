package com.revature.runbuddy.presentation.title

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.hannesdorfmann.mosby3.MviController
import com.revature.runbuddy.R
import com.revature.runbuddy.databinding.ControllerTitleScreenBinding
import io.reactivex.Observable

class TitleController : MviController<TitleView,TitlePresenter>(),TitleView{
    private lateinit var text:TextView
    private lateinit var button:Button


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup,
        savedViewState: Bundle?
    ): View {
        Log.d("TitleController","Creating View")
        val view = inflater.inflate(R.layout.controller_title_screen,container,false)

        setup(view)
        Log.d("TitleController","View Created")

        return view

    }
    private fun setup(view:View){
        val binding =ControllerTitleScreenBinding.bind(view)
        text = binding.textTitle
        button = binding.buttonTitle
    }

    override fun createPresenter() = TitlePresenter()

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

}