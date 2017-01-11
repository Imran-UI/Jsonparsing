package com.example.imran.jsonparsing.Services;

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

         public String modifiedquery;

     }

}


