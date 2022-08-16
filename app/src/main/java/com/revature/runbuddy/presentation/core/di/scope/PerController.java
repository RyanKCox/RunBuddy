package com.revature.runbuddy.presentation.core.di.scope;

import com.bluelinelabs.conductor.Controller;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope @Retention(RetentionPolicy.RUNTIME) public @interface PerController {
    Class<? extends Controller> value();
}