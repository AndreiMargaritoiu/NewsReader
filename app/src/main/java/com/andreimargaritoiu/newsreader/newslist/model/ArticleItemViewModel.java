package com.andreimargaritoiu.newsreader.newslist.model;

import androidx.databinding.ObservableField;

public class ArticleItemViewModel {

    public final ObservableField<String> articleTitle;
    public final ObservableField<String> articleDescription;
    public final ObservableField<String> articlePic;

    public ArticleItemViewModel() {
        articleTitle = new ObservableField<>();
        articleDescription = new ObservableField<>();
        articlePic = new ObservableField<>();
    }

}