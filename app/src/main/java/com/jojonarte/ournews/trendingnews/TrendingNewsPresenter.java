package com.jojonarte.ournews.trendingnews;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;

import com.jojonarte.ournews.R;
import com.jojonarte.ournews.data.NewsRepository;
import com.jojonarte.ournews.di.ScreenScope;
import com.jojonarte.ournews.model.Article;
import com.jojonarte.ournews.ui.ScreenNavigator;

import javax.inject.Inject;

@ScreenScope
public class TrendingNewsPresenter implements NewsAdapter.NewsClickedListener {

    private final TrendingNewsViewModel viewModel;
    private NewsRepository repository;
    private ScreenNavigator screenNavigator;
    @Inject Context context;

    @Inject
    TrendingNewsPresenter(TrendingNewsViewModel viewModel,
                          NewsRepository repository,
                          ScreenNavigator screenNavigator) {
        this.viewModel = viewModel;
        this.repository = repository;
        this.screenNavigator = screenNavigator;
        loadNews();
    }

    private void loadNews() {
        repository.getNews()
                .doOnSubscribe(__ -> viewModel.loadingUpdated().accept(true))
                .doOnEvent((d, t) -> viewModel.loadingUpdated().accept(false))
                .subscribe(viewModel.newsUpdated(), viewModel.onError());
    }

    @Override
    public void onArticleClicked(Article article) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(ContextCompat.getColor(context, R.color.colorPrimary));
        CustomTabsIntent intent = builder.build();
        intent.intent.setPackage("com.android.chrome");
        intent.intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.launchUrl(context, Uri.parse(article.url()));
    }
}
