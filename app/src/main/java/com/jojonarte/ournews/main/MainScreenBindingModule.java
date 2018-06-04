package com.jojonarte.ournews.main;

import com.bluelinelabs.conductor.Controller;
import com.jojonarte.ournews.di.ControllerKey;
import com.jojonarte.ournews.trendingnews.TrendingNewsComponent;
import com.jojonarte.ournews.trendingnews.TrendingNewsController;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
        TrendingNewsComponent.class
})
public abstract class MainScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(TrendingNewsController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindTrendingNewsInjector(TrendingNewsComponent.Builder builder);
}
