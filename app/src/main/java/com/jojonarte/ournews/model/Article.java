package com.jojonarte.ournews.model;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import org.threeten.bp.ZonedDateTime;

import javax.annotation.Nullable;

@AutoValue
public abstract class Article {

    public abstract Source source();

    @Nullable
    public abstract String author();

    public abstract String title();

    public abstract String description();

    public abstract String url();

    public abstract String urlToImage();

    public abstract ZonedDateTime publishedAt();

    public static JsonAdapter<Article> jsonAdapter(Moshi moshi) {
        return new AutoValue_Article.MoshiJsonAdapter(moshi);
    }
}
