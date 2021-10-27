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

import com.omellete.movieandshow.adapter.MoviesAdapter;
import com.omellete.movieandshow.viewmodel.MoviesViewModel;
import com.omellete.movieandshow.data.MovieEntity;
import com.omellete.movieandshow.databinding.FragmentMoviesBinding;

import java.util.List;

public class MoviesFragment extends Fragment {

    private FragmentMoviesBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentMoviesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            MoviesViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MoviesViewModel.class);
            List<MovieEntity> courses = viewModel.getMovies();

            MoviesAdapter academyAdapter = new MoviesAdapter();
            academyAdapter.setMovies(courses);

            binding.rvAcademy.setLayoutManager(new LinearLayoutManager(getContext()));
            binding.rvAcademy.setHasFixedSize(true);
            binding.rvAcademy.setAdapter(academyAdapter);
        }

    }
}