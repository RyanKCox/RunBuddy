package com.revature.runbuddy.presentation.core.di

import androidx.appcompat.app.AppCompatActivity
import dagger.MembersInjector

interface ActivityComponent<A : AppCompatActivity?> : MembersInjector<A>