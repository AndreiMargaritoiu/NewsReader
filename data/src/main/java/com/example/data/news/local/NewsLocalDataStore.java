package com.example.data.news.local;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public class NewsLocalDataStore {

    private ArticleDao dao;

    public NewsLocalDataStore(ArticleDao dao) {
        this.dao = dao;
    }

    public Single<List<ArticleEntity>> getArticleList() {
        return dao.queryArticleList();
    }

    public Single<List<ArticleEntity>> saveItems(List<ArticleEntity> articleEntities) {
        return Single.create(emitter -> {
            dao.insertArticleList(articleEntities);
            emitter.onSuccess(articleEntities);
        });
    }

    public Single<ArticleEntity> getArticle(int id) {
        return dao.queryArticle(id);
    }

    public Completable deleteArticle(int id) {
        return dao.deleteArticle(id);
    }

    public Completable insertArticle(ArticleEntity articleEntity) {
        return dao.insertArticle(articleEntity);
    }
}
