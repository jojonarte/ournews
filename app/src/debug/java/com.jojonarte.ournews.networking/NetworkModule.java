package com.jojonarte.ournews.networking;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Call;
import okhttp3.OkHttpClient;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    static Call.Factory provideOkhttp() {
        return new OkHttpClient.Builder().build();
    }

    @Provides
    @Named("base_url")
    static String provideBaseUrl() {
        return "http://newsapi.org";
    }
}
