package com.example.data.news.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface ArticleDao {

    @Query("SELECT * FROM news where title = :title")
    Single<ArticleEntity> queryArticle(String title);

    @Query("SELECT * FROM news")
    Single<List<ArticleEntity>> queryArticleList();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertArticleList(List<ArticleEntity> articles);

}
