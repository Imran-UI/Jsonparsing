package com.example.imran.jsonparsing.infrastructure;

import android.app.Application;

import com.example.imran.jsonparsing.live.Module;
import com.squareup.otto.Bus;

public class BeastmovieApplication extends Application{

    private Bus bus;

    public static final String API_KEY = "168b238b0b923d6713cafacc74d286c5";
    public static final String Base_Url = "https://api.themoviedb.org";
    public static final String base_picture_url="http://image.tmdb.org/t/p/w185";

    public BeastmovieApplication() {

        bus = new Bus();
    }

    public Bus getBus() {
        return bus;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Module.Register(this);
    }
}
