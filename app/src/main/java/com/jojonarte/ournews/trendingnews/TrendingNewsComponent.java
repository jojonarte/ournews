package com.jojonarte.ournews.trendingnews;

import com.jojonarte.ournews.di.ScreenScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ScreenScope
@Subcomponent
public interface TrendingNewsComponent extends AndroidInjector<TrendingNewsController> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<TrendingNewsController> {

    }
}
