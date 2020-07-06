package com.andreimargaritoiu.newsreader.newslist.navigator;

import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.andreimargaritoiu.newsreader.R;
import com.andreimargaritoiu.newsreader.article.fragment.ArticleDetailFragment;

public class ArticleNavigator {

    private static final String TAG = ArticleNavigator.class.getName();

    private FragmentManager fragmentManager;

    public ArticleNavigator(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void navigateToArticle(String articleTitle) {

        ArticleDetailFragment fragment = new ArticleDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ArticleDetailFragment.EXTRA_ARTICLE_NAME, articleTitle);

        fragment.setArguments(bundle);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment, ArticleDetailFragment.class.getSimpleName());
        transaction.addToBackStack(fragment.getClass().getSimpleName());

        transaction.commit();
    }
}
