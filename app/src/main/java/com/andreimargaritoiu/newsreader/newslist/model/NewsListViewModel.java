package com.andreimargaritoiu.newsreader.newslist.model;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.andreimargaritoiu.newsreader.R;
import com.andreimargaritoiu.newsreader.newslist.model.mapper.ArticlesToVMListMapper;
import com.andreimargaritoiu.newsreader.reactive.SingleLiveEvent;
import com.example.data.NewsRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class NewsListViewModel extends AndroidViewModel implements LifecycleObserver {

    private static final String TAG = NewsListViewModel.class.getName();

    private final static String LINK = "https://newsapi.org/";
    public final ObservableBoolean isLoading;
    public final SingleLiveEvent<Throwable> error;
    public final SingleLiveEvent<String> openLink;
    private final NewsRepository repo;
    public final ObservableField<String> resultText;

    public NewsListViewModel(Application application, NewsRepository repo) {
        super(application);
        this.repo = repo;
        this.isLoading = new ObservableBoolean();
        this.error = new SingleLiveEvent<>();
        this.openLink = new SingleLiveEvent<>();
        this.resultText = new ObservableField<>();
    }

    @NonNull
    public final ObservableList<ArticleItemViewModel> newsList = new ObservableArrayList<>();

    @SuppressLint("CheckResult")
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refresh() {
        isLoading.set(true);
        repo.getNewsArticles()
                .map(new ArticlesToVMListMapper())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::onNewsArticlesReceived,
                        this::onNewsArticlesError
                );
    }

    private void onNewsArticlesReceived(@NonNull List<ArticleItemViewModel> articles) {
        isLoading.set(false);
        Log.d(TAG, "onListReceived " + articles.size() + " items");
        newsList.clear();
        newsList.addAll(articles);
        resultText.set(getApplication().getString(R.string.results, articles.size()));
    }

    private void onNewsArticlesError(Throwable throwable) {
        isLoading.set(false);
        error.setValue(throwable);
    }

    public void onPoweredBySelected() {
        openLink.setValue(LINK);
    }
}
