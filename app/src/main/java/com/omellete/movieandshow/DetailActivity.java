package com.omellete.movieandshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.omellete.movieandshow.data.MovieEntity;
import com.omellete.movieandshow.data.ShowsEntity;
import com.omellete.movieandshow.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    public static final String PARCEL_NIH = "PARCEL_NIH";
    public static final String PARCEL_SHOW = "PARCEL_SHOW";
    public String itemName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar back = getSupportActionBar();
        if (back != null) {
            back.setDisplayHomeAsUpEnabled(true);
        }

        MovieEntity movieEntity = getIntent().getParcelableExtra(DetailActivity.PARCEL_NIH);
        ShowsEntity showsEntity = getIntent().getParcelableExtra(DetailActivity.PARCEL_SHOW);
//        Log.d("log======", movieEntity.getTitle());

        if (movieEntity != null) {
            setTitle("Movies Detail");
            binding.tvTittle.setText(movieEntity.getTitle());
            binding.tvDesc.setText(movieEntity.getDescription());
            binding.genreDetail.setText(movieEntity.getGenre());
            binding.tagLine.setText(movieEntity.getTagLine());
            binding.score.setText(movieEntity.getUserScore());
            binding.runTime.setText(movieEntity.getRunTime());
            Glide.with(this)
                    .load(movieEntity.getImagePath())
                    .into(binding.imgPoster);
            Glide.with(this)
                    .load(movieEntity.getBgPath())
                    .into(binding.gbDrop);
            itemName = movieEntity.getTitle();
        } else if (showsEntity != null) {
            setTitle("Tv Shows Detail");
            binding.tvTittle.setText(showsEntity.getTitle());
            binding.tvDesc.setText(showsEntity.getDescription());
            binding.genreDetail.setText(showsEntity.getGenre());
            binding.tagLine.setText(showsEntity.getTagLine());
            binding.score.setText(showsEntity.getUserScore());
            binding.runTime.setText(showsEntity.getRunTime());
            Glide.with(this)
                    .load(showsEntity.getImagePath())
                    .into(binding.imgPoster);
            Glide.with(this)
                    .load(showsEntity.getBgPath())
                    .into(binding.gbDrop);
            itemName = showsEntity.getTitle();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Hey! Im viewing " + itemName + " on TMDB!";
                String shareSub = "Hey! Im using TMDB Movie and Tv Show";
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
                break;
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}