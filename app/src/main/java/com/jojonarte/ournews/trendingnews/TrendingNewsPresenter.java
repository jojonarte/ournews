package com.jojonarte.ournews.trendingnews;

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
        // TODO:
    }
}
