package com.omellete.movieandshow.viewmodel;

import androidx.lifecycle.ViewModel;

import com.omellete.movieandshow.data.MovieEntity;
import com.omellete.movieandshow.data.ShowsEntity;
import com.omellete.movieandshow.data.SourceData;

import java.util.List;

public class ShowsViewModel extends ViewModel {

    public List<ShowsEntity> getShows() {
        return SourceData.generateShows();
    }
}
