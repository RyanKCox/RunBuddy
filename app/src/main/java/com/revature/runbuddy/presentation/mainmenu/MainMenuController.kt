package com.revature.runbuddy.presentation.mainmenu

import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import com.revature.runbuddy.MainActivity
import com.revature.runbuddy.R
import com.revature.runbuddy.databinding.ControllerMainmenuBinding
import com.revature.runbuddy.presentation.core.conductor.MviBaseController
import io.reactivex.Observable

class MainMenuController : MviBaseController<MainMenuView,MainMenuPresenter>(),MainMenuView{

    private lateinit var progressBar:ProgressBar
    private lateinit var progressText:TextView

    override fun getLayoutId() = R.layout.controller_mainmenu

    override fun onViewBound(view: View) {
        (activity as MainActivity).getActivityComponent()
            .inject(this)

        val binding = ControllerMainmenuBinding.bind(view)
        progressBar = binding.progressBar
        progressText = binding.textRunProgress

    }

    override fun startRunIntent(): Observable<Int> {
        TODO("Not yet implemented")
    }

    override fun render(state: MainMenuViewState) {
        when(state){
            is MainMenuViewState.Progress->{
                progressBar.visibility = View.GONE
                progressText.visibility = View.VISIBLE
                progressText.text = "${state.currentRun} out of ${state.allRuns}"

            }
            is MainMenuViewState.Loading->{
                progressBar.visibility = View.VISIBLE
                progressText.visibility = View.GONE

            }
        }
    }


}