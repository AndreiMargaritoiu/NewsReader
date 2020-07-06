package com.example.data.remote;

import com.example.data.news.remote.model.ArticleListDto;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {

    @GET("/v2/top-headlines")
    Single<ArticleListDto> getNewsArticles
            (@Query("apiKey") String apiKey, @Query("language") String language);
}
