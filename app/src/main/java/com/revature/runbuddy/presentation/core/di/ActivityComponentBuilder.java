package com.revature.runbuddy.presentation.core.di;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.revature.runbuddy.presentation.core.di.scope.ForActivity;

import dagger.BindsInstance;

@SuppressWarnings("rawtypes")
public interface ActivityComponentBuilder<C extends ActivityComponent,B extends ActivityComponentBuilder> {

    @BindsInstance B context(@ForActivity Context context);
    @BindsInstance B activity(AppCompatActivity activity);

    C build();
}
