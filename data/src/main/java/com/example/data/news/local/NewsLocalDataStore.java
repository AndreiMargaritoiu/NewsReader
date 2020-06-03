package com.example.data.news.local;

import android.util.Log;

import java.util.List;

import io.reactivex.Single;

public class NewsLocalDataStore {

    private static final String TAG = NewsLocalDataStore.class.getName();

    private ArticleDao dao;

    public NewsLocalDataStore(ArticleDao dao) {
        this.dao = dao;
    }

    public Single<List<ArticleEntity>> getArticleList() {
        Log.d(TAG, "There is no internet connection so we try to load articles " +
                "from local database");
        return dao.queryArticleList();
    }

    public Single<List<ArticleEntity>> saveItems(List<ArticleEntity> articleEntities) {
        return Single.create(emitter -> {
            Log.d(TAG, "We saved on the local database " + articleEntities.size() + " articles");
            dao.insertArticleList(articleEntities);
            emitter.onSuccess(articleEntities);
        });
    }

    public Single<ArticleEntity> getArticle(String articleTitle) {
        return dao.queryArticle(articleTitle);
    }
}
