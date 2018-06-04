package com.jojonarte.ournews.data;

import com.jojonarte.ournews.model.Article;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import javax.inject.Singleton;

import dagger.Provides;
import io.reactivex.Maybe;
import io.reactivex.Scheduler;
import io.reactivex.Single;

@Singleton
public class NewsRepository {
    private final Provider<NewsRequester> newsRequesterProvider;
    private final Scheduler scheduler;
    private final List<Article> cachedArticles = new ArrayList<>();

    @Inject
    NewsRepository(
        Provider<NewsRequester> newsRequesterProvider,
        @Named("network_scheduler") Scheduler scheduler) {
        this.newsRequesterProvider = newsRequesterProvider;
        this.scheduler = scheduler;
    }

    public Single<List<Article>> getNews() {
        return Maybe.concat(cachedNews(), apiNews())
                .firstOrError()
                .subscribeOn(scheduler);
    }

    public Maybe<List<Article>> cachedNews() {
        return Maybe.create(e -> {
            if (!cachedArticles.isEmpty()) {
                e.onSuccess(cachedArticles);
            }
            e.onComplete();
        });
    }

    private Maybe<List<Article>> apiNews() {
        return newsRequesterProvider.get().getNews()
                .doOnSuccess(news -> {
                    cachedArticles.clear();
                    cachedArticles.addAll(news);
                })
                .toMaybe();
    }
}
