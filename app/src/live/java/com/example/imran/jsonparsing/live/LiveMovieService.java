package com.example.imran.jsonparsing.live;

import com.example.imran.jsonparsing.Model.MovieModel;
import com.example.imran.jsonparsing.Model.ParentModel;
import com.example.imran.jsonparsing.Services.MovieService;
import com.example.imran.jsonparsing.entities.Movie;
import com.example.imran.jsonparsing.infrastructure.BeastmovieApplication;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveMovieService extends BaseLiveService{


    public LiveMovieService(BeastmovieApplication application, Moviewebservices api) {
        super(application, api);
    }

    @Subscribe
    public void  getMovieMessage(MovieService.SearchMoviesRequest request){

        final MovieService.SearchMoviesResponse movieresponse = new MovieService.SearchMoviesResponse();
        movieresponse.movies = new ArrayList<>();

        Call<ParentModel> call = api.loadMovie(request.query,BeastmovieApplication.API_KEY);

        call.enqueue(new Callback<ParentModel>() {
            @Override
            public void onResponse(Call<ParentModel> call, Response<ParentModel> response) {
                for(MovieModel moviemodel:response.body().movieinfos){
                    movieresponse.movies.add(new Movie(moviemodel.getMovietitle(),moviemodel.getMoviesummary(),moviemodel.getMoviereleasedate()
                    ,BeastmovieApplication.base_picture_url+moviemodel.getMovieposter(),moviemodel.getMovievote() ));
                }
                bus.post(movieresponse);
            }

            @Override
            public void onFailure(Call<ParentModel> call, Throwable t) {

            }
        });








    }
}
