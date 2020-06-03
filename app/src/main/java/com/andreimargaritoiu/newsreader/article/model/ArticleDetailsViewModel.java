package com.andreimargaritoiu.newsreader.article.model;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ViewModel;

import com.andreimargaritoiu.newsreader.article.mapper.EntityToDetailsVMMapper;
import com.example.data.NewsRepository;

public class ArticleDetailsViewModel extends ViewModel implements LifecycleObserver {

    private static final String TAG = ArticleDetailsViewModel.class.getName();

    private NewsRepository repository;

    public final ObservableField<String> title;
    public final ObservableField<String> description;
    public final ObservableField<String> content;
    public final ObservableField<String> image;

    public ArticleDetailsViewModel(NewsRepository repository) {
        this.repository = repository;
        this.title = new ObservableField<>("");
        this.description = new ObservableField<>("");
        this.content = new ObservableField<>("");
        this.image = new ObservableField<>("");
    }

    @SuppressLint("CheckResult")
    public void initArticleItem(String articleTitle) {
        Log.d(TAG, "initArticleItem()");

        if (title.get().isEmpty()) {
            this.title.set(articleTitle);
            repository.getArticle(articleTitle)
                    .map(new EntityToDetailsVMMapper(this))
                    .subscribe(
                            articleEntity -> Log.d(TAG, "articleItem: onSuccess : "
                                    + articleEntity.id),
                            throwable -> Log.e(TAG, "fetchArticleList error: ", throwable)
                    );
        }
    }
}
