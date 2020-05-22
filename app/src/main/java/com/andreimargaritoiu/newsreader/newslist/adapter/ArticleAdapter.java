package com.andreimargaritoiu.newsreader.newslist.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andreimargaritoiu.newsreader.databinding.ItemArticleBinding;
import com.andreimargaritoiu.newsreader.newslist.model.ArticleItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.TaskViewHolder> {

    private List<ArticleItemViewModel> newsList;

    public ArticleAdapter() {
        this.newsList = new ArrayList<>();
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemArticleBinding binder = ItemArticleBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);

        return new TaskViewHolder(binder);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.binding.setViewModel(newsList.get(position));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public void setItems(List<ArticleItemViewModel> items) {
        this.newsList = items;
        notifyDataSetChanged();
    }


    public class TaskViewHolder extends RecyclerView.ViewHolder {
        final ItemArticleBinding binding;

        public TaskViewHolder(ItemArticleBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
