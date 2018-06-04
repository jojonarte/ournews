package com.jojonarte.ournews.di;

import android.app.Activity;
import android.content.Context;

import com.jojonarte.ournews.base.MainApplication;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.android.AndroidInjector;

public class ActivityInjector {
    private Map<Class<? extends Activity>, Provider<AndroidInjector.Factory<? extends Activity>>> activityInjectors;

    @Inject
    ActivityInjector(Map<Class<? extends Activity>, Provider<AndroidInjector.Factory<? extends Activity>>> activityInjectors) {
        this.activityInjectors = activityInjectors;
    }

    void inject(Activity activity) {

    }

    void clear(Activity activity) {

    }

    static ActivityInjector get(Context context) {
        return ((MainApplication) context.getApplicationContext()).getActivityInjector();
    }
}
