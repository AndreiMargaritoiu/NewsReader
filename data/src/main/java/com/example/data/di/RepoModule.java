package com.example.data.di;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;

import com.example.data.NewsRepository;
import com.example.data.news.NewsRemoteSource;
import com.example.data.news.remote.NewsRepositoryImpl;
import com.example.data.remote.HttpClientFactory;

public class RepoModule {

    @NonNull
    private Context context;
    @NonNull
    private HttpClientFactory httpClientFactory;

    public RepoModule(@NonNull Application application) {
        this.context = application.getApplicationContext();
        this.httpClientFactory = new HttpClientFactory();
    }

    public NewsRepository provideNewsRepository() {
        return new NewsRepositoryImpl(provideNewsRemoteSource());
    }

    private NewsRemoteSource provideNewsRemoteSource() {
        return new NewsRemoteSource(httpClientFactory.getNewsApi());
    }
}
