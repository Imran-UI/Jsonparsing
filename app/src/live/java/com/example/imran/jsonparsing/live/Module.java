package com.example.imran.jsonparsing.live;


import android.view.ViewDebug;

import com.example.imran.jsonparsing.infrastructure.BeastmovieApplication;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Module {

    public static void Register(BeastmovieApplication application){

        new LiveMovieService(application,createMovieService());
    }

    public static Moviewebservices createMovieService(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BeastmovieApplication.Base_Url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Moviewebservices.class);

    }

}
