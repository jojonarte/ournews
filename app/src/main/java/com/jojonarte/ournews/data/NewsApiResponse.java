package com.jojonarte.ournews.data;

import com.google.auto.value.AutoValue;
import com.jojonarte.ournews.model.Article;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.List;

@AutoValue
public abstract class NewsApiResponse {

    @Json(name = "articles")
    public abstract List<Article> articles();

    public static JsonAdapter<NewsApiResponse> jsonAdapter(Moshi moshi) {
        return new AutoValue_NewsApiResponse.MoshiJsonAdapter(moshi);
    }
}
