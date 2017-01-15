package com.example.imran.jsonparsing.entities;

public class Movie {
    private String movieTitle;
    private String movieSummary;
    private String moviePicture;
    private String releaseDate;
    private double movieRating;


    public Movie(String movieTitle, String movieSummary, String releaseDate, String moviePicture, double movieRating) {
        this.movieTitle = movieTitle;
        this.movieSummary = movieSummary;
        this.releaseDate = releaseDate;
        this.moviePicture = moviePicture;
        this.movieRating = movieRating;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getMovieSummary() {
        return movieSummary;
    }

    public String getMoviePicture() {
        return moviePicture;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public double getMovieRating() {
        return movieRating;
    }
}
