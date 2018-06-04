package com.jojonarte.ournews.main;

import com.bluelinelabs.conductor.Controller;
import com.jojonarte.ournews.R;
import com.jojonarte.ournews.base.BaseActivity;
import com.jojonarte.ournews.trendingnews.TrendingNewsController;

public class MainActivity extends BaseActivity {

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected Controller initialScreen() {
        return new TrendingNewsController();
    }
}
