package com.andreimargaritoiu.newsreader.model;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import java.util.List;

public class NewsListViewModel extends ViewModel implements LifecycleObserver {

    private static final String TAG = NewsListViewModel.class.getName();

    @NonNull
    public final ObservableList<ArticleItemViewModel> newsList = new ObservableArrayList<>();

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refresh() {
        ArticleItemViewModel item1 = new ArticleItemViewModel();
        item1.articleName = new ObservableField<>("item1_title");
        item1.articleDescription = new ObservableField<>("item1_description");
        item1.articlePic = new ObservableField<>("");
        newsList.add(item1);
        ArticleItemViewModel item2 = new ArticleItemViewModel();
        item2.articleName = new ObservableField<>("item2_title");
        item2.articleDescription = new ObservableField<>("item2_description");
        item2.articlePic = new ObservableField<>("item2_description");
        newsList.add(item2);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void fetchToDoList() {
        Log.d(TAG, "fetchToDoList()");
    }


    private void onToDoListReceived(List<ArticleItemViewModel> article) {
        Log.d(TAG, "onToDoListReceived " + article.size() + " items");
        newsList.clear();
        newsList.addAll(article);
    }
}
