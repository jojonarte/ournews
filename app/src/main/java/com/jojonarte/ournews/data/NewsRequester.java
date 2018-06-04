package com.jojonarte.ournews.data;

import android.util.Log;

import com.jojonarte.ournews.model.Article;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import timber.log.Timber;

public class NewsRequester {

    private final NewsService service;

    @Inject
    NewsRequester(NewsService service) {
        this.service = service;
    }

    public Single<List<Article>> getNews() {
        return service.getNews()
                .map(NewsApiResponse::articles);
    }
}
