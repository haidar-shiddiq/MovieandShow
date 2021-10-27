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
import com.omellete.movieandshow.data.ShowsEntity;

import java.util.ArrayList;
import java.util.List;

public class ShowsAdapter extends RecyclerView.Adapter<ShowsAdapter.ListViewHolder>{
    private final ArrayList<ShowsEntity> listShow = new ArrayList<>();

    public void setShows(List<ShowsEntity> listShow) {
        if (listShow == null) return;
        this.listShow.clear();
        this.listShow.addAll(listShow);
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie_show, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        ShowsEntity showsEntity = listShow.get(position);

        Glide.with(holder.itemView.getContext())
                .load(showsEntity.getImagePath())
                .into(holder.avatarr);
        holder.title.setText(showsEntity.getTitle());
        holder.year.setText(showsEntity.getYear());
        holder.score.setText(showsEntity.getUserScore());
        holder.genre.setText(showsEntity.getGenre());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.PARCEL_SHOW, showsEntity);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listShow.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        final ImageView avatarr;
        final TextView title, year,score,genre;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            avatarr = itemView.findViewById(R.id.img_poster);
            title = itemView.findViewById(R.id.tv_item_title);
            year = itemView.findViewById(R.id.tv_item_date);
            score = itemView.findViewById(R.id.userScore);
            genre = itemView.findViewById(R.id.genre);
        }
    }

}
