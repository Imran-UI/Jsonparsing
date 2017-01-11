package com.example.imran.jsonparsing.live;

import com.example.imran.jsonparsing.Services.MovieService;
import com.example.imran.jsonparsing.infrastructure.BeastmovieApplication;
import com.squareup.otto.Subscribe;

public class LiveMovieService extends BaseLiveService{
    public LiveMovieService(BeastmovieApplication application) {
        super(application);
    }

    @Subscribe
    public void  getMovieMessage(MovieService.SearchMoviesRequest request){

        MovieService.SearchMoviesResponse response = new MovieService.SearchMoviesResponse();
        response.modifiedquery = request.query + "this is modifies query hahahahaha";
        bus.post(response);

    }
}
