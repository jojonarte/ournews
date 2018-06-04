package com.jojonarte.ournews.trendingnews;

import android.support.v7.util.DiffUtil;

import com.jojonarte.ournews.model.Article;

import java.util.List;

public class NewsDiffCallback extends DiffUtil.Callback  {
    private final List<Article> oldList;
    private final List<Article> newList;

    public NewsDiffCallback(List<Article> oldList, List<Article> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).url() == newList.get(newItemPosition).url();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
    }
}
