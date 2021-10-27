package com.omellete.movieandshow.data;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieEntity implements Parcelable {
    private String title;
    private String description;
    private String year;
    private String bgPath;
    private String imagePath;
    private String genre;
    private String runTime;
    private String userScore;
    private String tagLine;

    public MovieEntity(String title, String description, String year, String bgPath, String imagePath, String genre, String runTime, String userScore, String tagLine) {
        this.title = title;
        this.description = description;
        this.year = year;
        this.bgPath = bgPath;
        this.imagePath = imagePath;
        this.genre = genre;
        this.runTime = runTime;
        this.userScore = userScore;
        this.tagLine = tagLine;
    }

    protected MovieEntity(Parcel in) {
        title = in.readString();
        description = in.readString();
        year = in.readString();
        bgPath = in.readString();
        imagePath = in.readString();
        genre = in.readString();
        runTime = in.readString();
        userScore = in.readString();
        tagLine = in.readString();
    }

    public static final Creator<MovieEntity> CREATOR = new Creator<MovieEntity>() {
        @Override
        public MovieEntity createFromParcel(Parcel in) {
            return new MovieEntity(in);
        }

        @Override
        public MovieEntity[] newArray(int size) {
            return new MovieEntity[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBgPath() {
        return bgPath;
    }

    public void setBgPath(String bgPath) {
        this.bgPath = bgPath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getUserScore() {
        return userScore;
    }

    public void setUserScore(String userScore) {
        this.userScore = userScore;
    }

    public String getTagLine() {
        return tagLine;
    }

    public void setTagLine(String tagLine) {
        this.tagLine = tagLine;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeString(year);
        parcel.writeString(bgPath);
        parcel.writeString(imagePath);
        parcel.writeString(genre);
        parcel.writeString(runTime);
        parcel.writeString(userScore);
        parcel.writeString(tagLine);
    }
}
