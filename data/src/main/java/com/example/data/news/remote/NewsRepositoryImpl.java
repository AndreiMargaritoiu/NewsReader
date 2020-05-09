package com.example.data.news.remote;

import androidx.annotation.NonNull;

import com.example.data.NewsRepository;
import com.example.data.news.NewsRemoteSource;
import com.example.data.news.model.Article;
import com.example.data.news.remote.mapper.NewsDtoToNewsMapper;
import io.reactivex.Single;
import java.util.List;

public class NewsRepositoryImpl implements NewsRepository {

    private final NewsRemoteSource remoteSource;

    public NewsRepositoryImpl(NewsRemoteSource remoteSource) {
        this.remoteSource = remoteSource;
    }

    @Override
    @NonNull
    public Single<List<Article>> getNewsArticles() {
        return remoteSource.getNewsArticles()
                .map(new NewsDtoToNewsMapper());
    }
}
