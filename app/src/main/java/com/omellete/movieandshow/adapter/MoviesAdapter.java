package com.omellete.movieandshow.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.omellete.movieandshow.DetailActivity;
import com.omellete.movieandshow.R;
import com.omellete.movieandshow.data.MovieEntity;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ListViewHolder>{
    private final ArrayList<MovieEntity> listMovie = new ArrayList<>();

    public void setMovies(List<MovieEntity> listMovie) {
        if (listMovie == null) return;
        this.listMovie.clear();
        this.listMovie.addAll(listMovie);
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie_show, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        MovieEntity movieEntity = listMovie.get(position);

        Glide.with(holder.itemView.getContext())
                .load(movieEntity.getImagePath())
                .into(holder.avatarr);
        holder.title.setText(movieEntity.getTitle());
        holder.year.setText(movieEntity.getYear());
        holder.score.setText(movieEntity.getUserScore());
        holder.genre.setText(movieEntity.getGenre());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.PARCEL_NIH, movieEntity);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        final ImageView avatarr;
        final TextView title, year,score,genre;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            avatarr = itemView.findViewById(R.id.img_poster);
            title = itemView.findViewById(R.id.tv_item_title);
            year = itemView.findViewById(R.id.tv_item_date);
            score= itemView.findViewById(R.id.userScore);
            genre = itemView.findViewById(R.id.genre);
        }
    }

}