package com.omellete.movieandshow.viewmodel;

import androidx.lifecycle.ViewModel;

import com.omellete.movieandshow.data.MovieEntity;
import com.omellete.movieandshow.data.SourceData;

import java.util.List;

public class MoviesViewModel extends ViewModel {

    public List<MovieEntity> getMovies() {
        return SourceData.generateMovies();
    }
}
