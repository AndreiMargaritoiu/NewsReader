package com.andreimargaritoiu.newsreader.model;

import androidx.databinding.ObservableField;

public class ArticleItemViewModel {

    public ObservableField<String> articleName;
    public ObservableField<String> articleDescription;
    public ObservableField<String> articlePic;

    public ArticleItemViewModel() {
        articleDescription = new ObservableField<>();
        articleName = new ObservableField<>();
    }

}