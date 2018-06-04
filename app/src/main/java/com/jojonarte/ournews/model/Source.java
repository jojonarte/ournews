package com.jojonarte.ournews.model;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import javax.annotation.Nullable;

@AutoValue
public abstract class Source {

    @Nullable
    public abstract String id();

    public abstract String name();

    public static JsonAdapter<Source> jsonAdapter(Moshi moshi) {
        return new AutoValue_Source.MoshiJsonAdapter(moshi);
    }

}
