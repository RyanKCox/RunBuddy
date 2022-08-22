package com.revature.runbuddy.data

data class RunningSession(
    val ID:Int,
    val description:String,
    val completedOn:Long?,
    val routine:List<ExerciseAction>
)
data class ExerciseAction(
    val description:String,
    val duration:Long
)