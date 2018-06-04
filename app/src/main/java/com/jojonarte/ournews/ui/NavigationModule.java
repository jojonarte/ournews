package com.jojonarte.ournews.ui;

import dagger.Binds;
import dagger.Module;
@Module
public abstract class NavigationModule {

    @Binds
    abstract ScreenNavigator provideScreenNavigator(DefaultScreenNavigator screenNavigator);
}
