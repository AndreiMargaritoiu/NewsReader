package com.example.data.news.remote.mapper;

import com.example.data.news.local.ArticleEntity;
import com.example.data.news.model.Article;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ArticleEntityToArticlesMapper implements Function<List<ArticleEntity>, List<Article>> {

    @Override
    public List<Article> apply(List<ArticleEntity> articleEntities) {
        List<Article> articles = new ArrayList<>();

        for (ArticleEntity entity : articleEntities) {
            Article article = new Article(
                    entity.urlToImage != null ? entity.urlToImage : "",
                    entity.title != null ? entity.title : "",
                    entity.content != null ? entity.content : "",
                    entity.description != null ? entity.description : ""
            );

            articles.add(article);
        }

        return articles;
    }


}
