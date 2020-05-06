package com.andreimargaritoiu.newsreader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import com.andreimargaritoiu.newsreader.model.NewsListViewModel;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_list_fragment);
        NewsListViewModel viewModel = ViewModelProviders.of(this)
                .get(NewsListViewModel.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (disposable != null) {
            disposable.dispose();
        }
    }
}
