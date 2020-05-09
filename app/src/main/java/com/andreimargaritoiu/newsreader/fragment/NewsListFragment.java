package com.andreimargaritoiu.newsreader.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.andreimargaritoiu.newsreader.databinding.ArticleListFragmentBinding;
import com.andreimargaritoiu.newsreader.model.NewsListViewModel;

public class NewsListFragment extends Fragment {

    private NewsListViewModel viewModel;

    public static NewsListFragment newInstance() {
        return new NewsListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = ViewModelProviders.of(requireActivity()).get(NewsListViewModel.class);

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
}