package com.andreimargaritoiu.newsreader.article.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.andreimargaritoiu.newsreader.article.model.ArticleDetailsViewModel;
import com.andreimargaritoiu.newsreader.databinding.ArticleDetailsFragmentBinding;
import com.andreimargaritoiu.newsreader.newslist.model.factory.ViewModelFactory;

public class ArticleDetailFragment extends Fragment {

    public final static String EXTRA_ARTICLE_NAME = "EXTRA_ARTICLE_NAME";
    private ArticleDetailsViewModel viewModel;

    private static final String TAG = ArticleDetailFragment.class.getName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewModelFactory factory = new ViewModelFactory(requireActivity().getApplication());
        viewModel = new ViewModelProvider(requireActivity(), factory).get(ArticleDetailsViewModel.class);

        if (getArguments() != null && getArguments().containsKey(EXTRA_ARTICLE_NAME)) {
            viewModel.initArticleItem(getArguments().getString(EXTRA_ARTICLE_NAME));
        }

        //for those lifecycle callbacks in view model, like ON_CREATE
        getLifecycle().addObserver(viewModel);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ArticleDetailsFragmentBinding binding =
                ArticleDetailsFragmentBinding.inflate(inflater, container, false);

        binding.setViewModel(viewModel);

        return binding.getRoot();
    }
}
