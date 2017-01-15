package com.example.imran.jsonparsing.Services;

import com.example.imran.jsonparsing.entities.Movie;

import java.util.ArrayList;

public class MovieService {

    private MovieService() {
    }

    public static class SearchMoviesRequest{

        public String query;

        public SearchMoviesRequest(String query) {
            this.query = query;
        }
    }

     public static class SearchMoviesResponse{

         public ArrayList<Movie> movies;

     }

}


