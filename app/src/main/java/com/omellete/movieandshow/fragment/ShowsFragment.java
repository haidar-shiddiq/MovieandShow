package com.omellete.movieandshow.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.omellete.movieandshow.R;
import com.omellete.movieandshow.adapter.MoviesAdapter;
import com.omellete.movieandshow.adapter.ShowsAdapter;
import com.omellete.movieandshow.data.MovieEntity;
import com.omellete.movieandshow.data.ShowsEntity;
import com.omellete.movieandshow.databinding.FragmentMoviesBinding;
import com.omellete.movieandshow.databinding.FragmentShowsBinding;
import com.omellete.movieandshow.viewmodel.MoviesViewModel;
import com.omellete.movieandshow.viewmodel.ShowsViewModel;

import java.util.List;

public class ShowsFragment extends Fragment {

    private FragmentShowsBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentShowsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            ShowsViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(ShowsViewModel.class);
            List<ShowsEntity> courses = viewModel.getShows();

            ShowsAdapter academyAdapter = new ShowsAdapter();
            academyAdapter.setShows(courses);

            binding.rvAcademy.setLayoutManager(new LinearLayoutManager(getContext()));
            binding.rvAcademy.setHasFixedSize(true);
            binding.rvAcademy.setAdapter(academyAdapter);
        }

    }
}