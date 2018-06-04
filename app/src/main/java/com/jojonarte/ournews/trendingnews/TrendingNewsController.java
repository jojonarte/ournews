package com.jojonarte.ournews.trendingnews;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.jojonarte.ournews.R;
import com.jojonarte.ournews.base.BaseController;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class TrendingNewsController extends BaseController {

    @Inject TrendingNewsPresenter presenter;
    @Inject TrendingNewsViewModel viewModel;

    @BindView(R.id.news_list) RecyclerView newsList;
    @BindView(R.id.loading_indicator) View loadingView;
    @BindView(R.id.tv_error) TextView errorText;

    @Override
    protected void onViewBound(View view) {
        newsList.setLayoutManager(new LinearLayoutManager(view.getContext()));
        newsList.setAdapter(new NewsAdapter(presenter));
    }

    @Override
    protected Disposable[] subscriptions() {
        return new Disposable[] {
                viewModel.loading()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(loading -> {
                        loadingView.setVisibility(loading ? View.VISIBLE : View.GONE);
                        newsList.setVisibility(loading ? View.GONE : View.VISIBLE);
                        errorText.setVisibility(loading ? View.GONE : View.VISIBLE);
                }),
                viewModel.news()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(((NewsAdapter) newsList.getAdapter())::setData),
                viewModel.error()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(errorRes -> {
                    if (errorRes == -1) {
                        errorText.setText(null);
                        errorText.setVisibility(View.GONE);
                    } else {
                        errorText.setVisibility(View.VISIBLE);
                        newsList.setVisibility(View.GONE);
                        errorText.setText(errorRes);
                    }
                })
        };
    }

    @Override
    protected int layoutRes() {
        return R.layout.screen_trending_news;
    }
}
