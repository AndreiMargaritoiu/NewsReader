package com.example.data.store.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.data.news.local.ArticleDao;
import com.example.data.news.local.ArticleEntity;

@Database(entities = {ArticleEntity.class}, version = 1)
public abstract class NewsDatabase extends RoomDatabase {

    public abstract ArticleDao articleDao();
}
