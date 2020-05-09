package com.example.data.news;

import androidx.annotation.NonNull;
import com.example.data.news.remote.model.ArticleListDto;
import com.example.data.remote.NewsApi;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class NewsRemoteSource {

    private static final String API_KEY = "0ab768be7b304eab937cd57cb39a5f0f";
    private static final String EN_LANGUAGE_FILTER = "en";

    @NonNull
    private final NewsApi newsApi;

    public NewsRemoteSource(NewsApi newsApi) {
        this.newsApi = newsApi;
    }

    public Single<ArticleListDto> getNewsArticles() {
        return newsApi.getNewsArticles(API_KEY, EN_LANGUAGE_FILTER)
                .subscribeOn(Schedulers.io());
    }
}
