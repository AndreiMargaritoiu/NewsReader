package com.andreimargaritoiu.newsreader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import com.andreimargaritoiu.newsreader.newslist.fragment.NewsListFragment;
import com.andreimargaritoiu.newsreader.newslist.model.NewsListViewModel;
import com.andreimargaritoiu.newsreader.newslist.model.factory.ViewModelFactory;
import com.andreimargaritoiu.newsreader.newslist.navigator.ArticleNavigator;

import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    private ArticleNavigator navigator;
    private Disposable disposable;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, NewsListFragment.newInstance())
                    .commitNow();
        }

        navigator = new ArticleNavigator(getSupportFragmentManager());
        ViewModelFactory factory = new ViewModelFactory(getApplication());
        NewsListViewModel viewModel = new ViewModelProvider(this, factory).get(NewsListViewModel.class);

        disposable = viewModel.events.subscribe(
                articleEventModel -> navigator.onArticleEvent(articleEventModel),
                throwable -> Log.d(TAG, "")
        );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (disposable != null) {
            disposable.dispose();
        }
    }
}
