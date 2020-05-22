package com.andreimargaritoiu.newsreader.newslist.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.andreimargaritoiu.newsreader.databinding.ArticleListFragmentBinding;
import com.andreimargaritoiu.newsreader.newslist.model.NewsListViewModel;
import com.andreimargaritoiu.newsreader.newslist.model.factory.ViewModelFactory;

public class NewsListFragment extends Fragment {

    private NewsListViewModel viewModel;

    public static NewsListFragment newInstance() {
        return new NewsListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this, new ViewModelFactory
                (requireActivity().getApplication())).get(NewsListViewModel.class);
        viewModel.openLink.observe(this, link -> openLink(link));
        //for those lifecycle callbacks in view model, like ON_CREATE
        getLifecycle().addObserver(viewModel);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ArticleListFragmentBinding binding = ArticleListFragmentBinding
                .inflate(inflater, container, false);

        binding.setViewModel(viewModel);

        return binding.getRoot();
    }

    private void openLink(@NonNull String link) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(link));
        startActivity(i);
    }
}