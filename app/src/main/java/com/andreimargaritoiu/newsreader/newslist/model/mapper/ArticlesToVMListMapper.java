package com.andreimargaritoiu.newsreader.newslist.model.mapper;

import android.util.Log;

import com.andreimargaritoiu.newsreader.newslist.model.ArticleItemViewModel;
import com.example.data.news.model.Article;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ArticlesToVMListMapper implements Function<List<Article>, List<ArticleItemViewModel>> {

    @Override
    public List<ArticleItemViewModel> apply(List<Article> articles) {

        List<ArticleItemViewModel> vmItems = new ArrayList<>();
        for (Article dataItem : articles) {
            ArticleItemViewModel viewModelArticle = new ArticleItemViewModel();

            viewModelArticle.articleTitle.set(dataItem.title);
            viewModelArticle.articleDescription.set(dataItem.description);
            viewModelArticle.articlePic.set(dataItem.imageUrl);

            vmItems.add(viewModelArticle);
        }

        return vmItems;
    }
}
