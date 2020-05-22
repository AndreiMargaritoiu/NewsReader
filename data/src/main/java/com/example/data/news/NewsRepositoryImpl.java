package com.example.data.news;

import androidx.annotation.NonNull;

import com.example.data.NewsRepository;
import com.example.data.news.local.ArticleEntity;
import com.example.data.news.remote.NewsRemoteSource;
import com.example.data.news.local.NewsLocalDataStore;
import com.example.data.news.model.Article;
import com.example.data.news.remote.mapper.ArticleEntityToArticlesMapper;
import com.example.data.news.remote.model.ArticleDto;

import io.reactivex.Single;

import java.util.ArrayList;
import java.util.List;

public class NewsRepositoryImpl implements NewsRepository {

    private final NewsRemoteSource remoteSource;
    private NewsLocalDataStore localSource;

    public NewsRepositoryImpl(NewsRemoteSource remoteSource, NewsLocalDataStore localSource) {
        this.localSource = localSource;
        this.remoteSource = remoteSource;
    }

//    @Override
//    @NonNull
//    public Single<List<Article>> getNewsArticles() {
//        return remoteSource.getNewsArticles()
//                .map(new NewsDtoToNewsMapper());
//    }

    @NonNull
    @Override
    public Single<List<Article>> getNewsArticles() {
        return remoteSource.getNewsArticles()
                .map(articleListDto -> {
                    List<ArticleEntity> articleEntityList = new ArrayList<>();
                    List<ArticleDto> list1 = articleListDto.articles;
                    for (ArticleDto article : list1) {
                        ArticleEntity articleEntity = new ArticleEntity();
                        articleEntity.setTitle(article.title);
                        articleEntity.setUrlToImage(article.urlToImage);
                        articleEntity.setContent(article.content);
                        articleEntity.setDescription(article.description);
                        articleEntityList.add(articleEntity);
                    }
                    return articleEntityList;
                })
                .flatMap(localSource::saveItems)
                .onErrorResumeNext(localSource.getArticleList())
                .map(new ArticleEntityToArticlesMapper());
    }
}
