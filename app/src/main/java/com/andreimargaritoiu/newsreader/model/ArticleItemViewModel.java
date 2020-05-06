package com.andreimargaritoiu.newsreader.model;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableField;

public class ArticleItemViewModel {

    @Nullable
    public Integer id;
    public ObservableField<String> articleName;
    public ObservableField<String> articleDescription;
    @DrawableRes
    public int articlePic;

    public ArticleItemViewModel() {
        articleDescription = new ObservableField<>();
        articleName = new ObservableField<>();
    }

}