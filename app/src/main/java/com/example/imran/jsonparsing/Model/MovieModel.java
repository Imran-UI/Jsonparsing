package com.example.imran.jsonparsing.Model;


import com.google.gson.annotations.SerializedName;

public class MovieModel {

    @SerializedName("poster_path")
    String movieposter;

    @SerializedName("vote_average")
    double movievote;

    @SerializedName("title")
    String movietitle;

    @SerializedName("overview")
    String moviesummary;

    @SerializedName("release_date")
    String moviereleasedate;

    public String getMovieposter() {
        return movieposter;
    }

    public double getMovievote() {
        return movievote;
    }

    public String getMovietitle() {
        return movietitle;
    }

    public String getMoviesummary() {
        return moviesummary;
    }

    public String getMoviereleasedate() {
        return moviereleasedate;
    }
}
