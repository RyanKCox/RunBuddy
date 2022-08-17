package com.revature.runbuddy.presentation.core.conductor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.rxlifecycle2.RxRestoreViewOnCreateController;
import com.hannesdorfmann.mosby3.MviConductorDelegateCallback;
import com.hannesdorfmann.mosby3.MviConductorLifecycleListener;
import com.hannesdorfmann.mosby3.MviController;
import com.hannesdorfmann.mosby3.mvi.MviPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.revature.runbuddy.presentation.core.di.ConductorInjection;
import com.revature.runbuddy.presentation.core.di.injectors.HasControllerInjector;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;

@SuppressWarnings("rawtypes")
public abstract class MviBaseController<V extends MvpView,P extends MviPresenter<V,?>>
        extends
        MviController<V,P>
        implements
        HasControllerInjector,
        MvpView,
        MviConductorDelegateCallback<V,P> {

    @Inject
    DispatchingAndroidInjector<Controller> controllerInjector;

    private boolean shouldSetLifecycleListeners = true;

//    private final LifecycleListener viewBoundControllerLifecycleListener =
//        new LifecycleListener() {
//            @Override
//            public void postCreateView(@NonNull Controller controller, @NonNull View view) {
//                onViewBound(view);
//            }
//        };
    private final Controller.LifecycleListener mviConductorLifecycleListener =
        new MviConductorLifecycleListener<>(this);

    @Inject P presenter;

    @NonNull @Override public P createPresenter(){
        return presenter;
    }
    public MviBaseController(){
        this(null);
    }
    public MviBaseController(Bundle args){
        super(args);
        addLifecycleListener(new LifecycleListener() {
            @Override
            public void preCreateView(@NonNull Controller controller) {
                super.preCreateView(controller);
                if(shouldSetLifecycleListeners){
//                    addLifecycleListener(viewBoundControllerLifecycleListener);
                    addLifecycleListener(mviConductorLifecycleListener);
                    shouldSetLifecycleListeners = false;
                }
            }
        });
    }

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @Nullable Bundle savedViewState) {
        if(controllerInjector == null)
            injectDependencies();
        View view = inflater.inflate(getLayoutId(),container,false);
        onViewBound(view);
        return view;
    }
    private void injectDependencies(){
        ConductorInjection.Companion.inject(this);
    }
    @LayoutRes protected abstract int getLayoutId();

    protected void onViewBound(View view){}

    @NonNull
    @Override
    public DispatchingAndroidInjector<Controller> controllerInjector() {
        return controllerInjector;
    }

    @NonNull
    @Override
    public V getMvpView() {
        try {
            return (V) this;
        } catch (ClassCastException e){
            throw new RuntimeException("View not connect, check MvpView override",e);
        }
    }
}
