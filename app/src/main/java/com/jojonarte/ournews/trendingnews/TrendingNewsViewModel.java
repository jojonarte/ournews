package com.jojonarte.ournews.trendingnews;

import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jojonarte.ournews.R;
import com.jojonarte.ournews.di.ScreenScope;
import com.jojonarte.ournews.model.Article;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

@ScreenScope
public class TrendingNewsViewModel {

    private final BehaviorRelay<List<Article>> articlesRelay = BehaviorRelay.create();
    private final BehaviorRelay<Integer> errorRelay = BehaviorRelay.create();
    private final BehaviorRelay<Boolean> loadingRelay = BehaviorRelay.create();

    @Inject
    TrendingNewsViewModel() {

    }

    Observable<Boolean> loading() {
        return loadingRelay;
    }

    Observable<List<Article>> news() {
        return articlesRelay;
    }

    Observable<Integer> error() {
        return errorRelay;
    }

    Consumer<Boolean> loadingUpdated() {
        return loadingRelay;
    }

    Consumer<List<Article>> newsUpdated() {
        errorRelay.accept(-1);
        return articlesRelay;
    }

    Consumer<Throwable> onError() {
        return throwable -> {
            Timber.e(throwable, "Error loading Articles");
            errorRelay.accept(R.string.api_error_repos);
        };
    }
}

