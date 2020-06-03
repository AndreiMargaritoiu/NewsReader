package com.andreimargaritoiu.newsreader.newslist.navigator;

import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.andreimargaritoiu.newsreader.R;
import com.andreimargaritoiu.newsreader.article.fragment.ArticleDetailFragment;
import com.andreimargaritoiu.newsreader.newslist.model.ArticleEventModel;
import com.andreimargaritoiu.newsreader.newslist.model.ArticleItemViewModel;

public class ArticleNavigator {

    private static final String TAG = ArticleNavigator.class.getName();

    private FragmentManager fragmentManager;

    public ArticleNavigator(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void onArticleEvent(ArticleEventModel articleEventModel) {
        if (articleEventModel.eventType == ArticleEventModel.EventType.VIEW_ITEM) {
            openArticleDetailScreen(articleEventModel.item);
        }
    }

    private void openArticleDetailScreen(ArticleItemViewModel item) {
        ArticleDetailFragment fragment = new ArticleDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ArticleDetailFragment.EXTRA_ARTICLE_NAME, item.articleTitle.get());

        fragment.setArguments(bundle);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main, fragment, ArticleDetailFragment.class.getSimpleName());
        transaction.addToBackStack(fragment.getClass().getSimpleName());

        transaction.commit();
    }

    public void onArticleClicked(ArticleEventModel articleEventModel) {
        ArticleDetailFragment fragment = new ArticleDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ArticleDetailFragment.EXTRA_ARTICLE_NAME,
                articleEventModel.item.articleTitle.get());

        fragment.setArguments(bundle);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main, fragment, ArticleDetailFragment.class.getSimpleName());
        transaction.addToBackStack(fragment.getClass().getSimpleName());

        transaction.commit();
    }
}
