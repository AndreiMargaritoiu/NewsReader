package com.andreimargaritoiu.newsreader.newslist.model;

import androidx.databinding.ObservableField;

public class ArticleItemViewModel {

    public final ObservableField<String> articleName;
    public final ObservableField<String> articleDescription;
    public final ObservableField<String> articlePic;

    public ArticleItemViewModel() {
        articleDescription = new ObservableField<>();
        articleName = new ObservableField<>();
        articlePic = new ObservableField<>();
    }

}