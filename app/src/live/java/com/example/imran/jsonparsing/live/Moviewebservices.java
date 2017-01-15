package com.example.imran.jsonparsing.live;


import com.example.imran.jsonparsing.Model.ParentModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Moviewebservices {
    @GET("/3/movie/{parameter}")
    Call<ParentModel> loadMovie(
        @Path("parameter") String requesttype,
        @Query("api_key") String APIKEY
    ) ;

}
