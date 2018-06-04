package com.jojonarte.ournews.trendingnews;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jojonarte.ournews.R;
import com.jojonarte.ournews.model.Article;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsAdapter  extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private final NewsClickedListener listener;
    private final List<Article> data = new ArrayList<>();

    NewsAdapter(NewsClickedListener listener) {
        this.listener = listener;
//        setHasStableIds(false);
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_news_list_item, parent, false);
        return new NewsViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).hashCode();
    }

    void setData(List<Article> articles) {
        if (articles != null) {
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new NewsDiffCallback(data, articles));
            data.clear();
            data.addAll(articles);
            diffResult.dispatchUpdatesTo(this);
        }
        else {
            data.clear();
            notifyDataSetChanged();
        }
    }
    static final class NewsViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_news_title) TextView newsTitleText;
        @BindView(R.id.tv_news_description) TextView newsDescriptionText;

        private Article article;

        public NewsViewHolder(View itemView, NewsClickedListener listener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> {
                if (article != null) {
                    listener.onArticleClicked(article);
                }
            });
        }

        void bind(Article article) {
            this.article = article;
            newsTitleText.setText(article.title());
            newsDescriptionText.setText(article.description());
        }
    }

    interface NewsClickedListener {
        void onArticleClicked(Article article);
    }
}
