package com.andreimargaritoiu.newsreader.article.mapper;

import com.andreimargaritoiu.newsreader.article.model.ArticleDetailsViewModel;
import com.example.data.news.local.ArticleEntity;

import io.reactivex.functions.Function;

public class EntityToDetailsVMMapper implements Function<ArticleEntity, ArticleEntity> {

    private final ArticleDetailsViewModel articleDetailsViewModel;

    public EntityToDetailsVMMapper(ArticleDetailsViewModel articleDetailsViewModel) {
        this.articleDetailsViewModel = articleDetailsViewModel;
    }

    @Override
    public ArticleEntity apply(ArticleEntity articleEntity) {
        articleDetailsViewModel.title.set(articleEntity.title);
        articleDetailsViewModel.description.set(articleEntity.description);
        articleDetailsViewModel.content.set(articleEntity.content);
        articleDetailsViewModel.image.set(articleEntity.urlToImage);
        return articleEntity;
    }
}
