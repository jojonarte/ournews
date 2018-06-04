package com.jojonarte.ournews.base;

import com.jojonarte.ournews.data.NewsServiceModule;
import com.jojonarte.ournews.networking.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class,
        ServiceModule.class,
        NewsServiceModule.class,
})
public interface ApplicationComponent {
    void inject(MainApplication application);
}
