package com.example.data.news.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface ArticleDao {

    @Query("SELECT * FROM news")
    Single<List<ArticleEntity>> queryArticleList();

    @Query("SELECT * FROM news where id= :id")
    Single<ArticleEntity> queryArticle(int id);

    @Query("DELETE FROM news where id=:id")
    Completable deleteArticle(int id);

    @Query("DELETE FROM news")
    Completable deleteAllArtciles();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertArticleList(List<ArticleEntity> articles);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertArticle(ArticleEntity article);

}
