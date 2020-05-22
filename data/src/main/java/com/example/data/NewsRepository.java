package com.example.data;

import androidx.annotation.NonNull;

import com.example.data.news.model.Article;

import io.reactivex.Single;

import java.util.List;

public interface NewsRepository {

    @NonNull
    Single<List<Article>> getNewsArticles();
}
