package com.andreimargaritoiu.newsreader.newslist.model;

import androidx.annotation.IntDef;

public class ArticleEventModel {

    @EventType
    public final int eventType;

    public final ArticleItemViewModel item;

    ArticleEventModel(@EventType int eventType, ArticleItemViewModel item) {
        this.eventType = eventType;
        this.item = item;
    }

    @IntDef({
            EventType.VIEW_ITEM
    })

    public @interface EventType {
        int VIEW_ITEM = 1;
    }
}
