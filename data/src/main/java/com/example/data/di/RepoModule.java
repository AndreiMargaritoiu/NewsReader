package com.example.data.di;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;

import com.example.data.NewsRepository;
import com.example.data.news.remote.NewsRemoteSource;
import com.example.data.news.local.NewsLocalDataStore;
import com.example.data.news.NewsRepositoryImpl;
import com.example.data.remote.HttpClientFactory;
import com.example.data.store.local.NewsDatabase;

public class RepoModule {

    @NonNull
    private Context context;
    @NonNull
    private HttpClientFactory httpClientFactory;

    private volatile NewsDatabase database;

    public RepoModule(@NonNull Application application) {
        this.context = application.getApplicationContext();
        this.httpClientFactory = new HttpClientFactory();
    }

    public NewsRepository provideNewsRepository() {
        return new NewsRepositoryImpl(provideNewsRemoteSource(), provideLocalDataStore());
    }

    private NewsRemoteSource provideNewsRemoteSource() {
        return new NewsRemoteSource(httpClientFactory.getNewsApi());
    }

    NewsLocalDataStore provideLocalDataStore() {
        NewsDatabase database = getInstance();
        return new NewsLocalDataStore(database.articleDao());
    }

    NewsDatabase getInstance() {
        if (database == null) {
            synchronized (NewsDatabase.class) {
                if (database == null) {
                    database = Room.databaseBuilder(context.getApplicationContext(),
                            NewsDatabase.class, "Sample.db")
                            .build();
                }
            }
        }
        return database;
    }
}
