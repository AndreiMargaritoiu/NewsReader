package com.andreimargaritoiu.newsreader.bindings;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.andreimargaritoiu.newsreader.newslist.adapter.ArticleAdapter;
import com.andreimargaritoiu.newsreader.newslist.model.ArticleItemViewModel;

import java.util.List;

public class RecylerBindings {

    @BindingAdapter({"items"})
    public static void addFeedItems(RecyclerView recyclerView, List<ArticleItemViewModel> articles) {
        ArticleAdapter articleAdapter = (ArticleAdapter) recyclerView.getAdapter();

        if (articleAdapter == null) {
            articleAdapter = new ArticleAdapter();
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(articleAdapter);
        }

        articleAdapter.setItems(articles);
    }
}
