package com.example.imran.jsonparsing.live;


import com.example.imran.jsonparsing.infrastructure.BeastmovieApplication;

public class Module {

    public static void Register(BeastmovieApplication application){

        new LiveMovieService(application);
    }
}
